<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin page -->
<div class="row">
	<input type="hidden" id="wallet_id" value="${wallet.getId()}">
	<div class="row">
		<div class="col-lg-12">
			<a href="list_movement.html?wallet=${wallet.getId()}">
				<button type="button"
					class="btn btn-primary btn-bordred waves-effect w-md waves-light m-b-5">
					<i class="fa fa-arrow-left" aria-hidden="true"></i> &nbsp; Volver a
					mis movimientos
				</button>
			</a> <a href="list_wallet.html">
				<button type="button"
					class="btn btn-custom btn-bordred waves-effect w-md waves-light m-b-5">
					<i class="fa fa-list-alt" aria-hidden="true"></i> &nbsp; Volver a
					mis Carteras
				</button>
			</a>
		</div>
	</div>
	<!-- end col-->

	<div class="col-lg-6">
		<div class="card-box">
			<h4 class="header-title m-t-0 m-b-30">Movimientos del último mes
				(${wallet.getName()})</h4>
			<div class="text-center">
				<ul class="list-inline chart-detail-list">
					<li>
						<h5 style="color: rgba(76, 255, 81, .8);">
							<i class="fa fa-circle m-r-5"></i>Ingresos
						</h5>
					</li>
					<li>
						<h5 style="color: rgba(255, 79, 76, .8);">
							<i class="fa fa-circle m-r-5"></i>Gastos
						</h5>
					</li>
				</ul>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<img alt="" src="assets/images/loader.gif" class="loader"
						style="display: none;">
					<canvas id="line-chartjs" height="450" width="600"></canvas>
				</div>
			</div>

		</div>
	</div>
	<!-- end col-->

	<div class="col-lg-6">
		<div class="card-box">
			<h4 class="header-title m-t-0 m-b-30">Balance de Gastos VS
				Ingresos (Wallet ${wallet.getName()})</h4>
			<div class="text-center">
				<ul class="list-inline chart-detail-list">
					<li>
						<h5 style="color: rgba(31,181,172,1);">
							<i class="fa fa-circle m-r-5"></i>Ingresos
						</h5>
					</li>
					<li>
						<h5 style="color: rgba(250,133,100,1.0);">
							<i class="fa fa-circle m-r-5"></i>Gastos
						</h5>
					</li>
				</ul>
			</div>
			<div class="row">

				<div
					class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
					<img alt="" src="assets/images/loader.gif" class="loader"
						style="display: none;">
					<canvas id="donut1" width="400" height="400"></canvas>
				</div>
			</div>
		</div>

	</div>
</div>
<div class="row">
	<div class="col-lg-6">
		<div class="card-box">
			<h4 class="header-title m-t-0 m-b-30">Balance de Gastos VS
				Ingresos (Todas tus Wallet)</h4>
			<div class="text-center">
				<ul class="list-inline chart-detail-list">
					<li>
						<h5 style="color: rgba(103, 210, 155,1);">
							<i class="fa fa-circle m-r-5"></i>Ingresos Totales
						</h5>
					</li>
					<li>
						<h5 style="color: rgba(211, 103, 154,1.0);">
							<i class="fa fa-circle m-r-5"></i>Gastos Totales
						</h5>
					</li>
				</ul>
			</div>
			<div class="row">
	           <div
					class="col-md-8 col-sm-8 col-xs-8 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
					<img alt="" src="assets/images/loader.gif" class="loader"
						style="display: none;">
					<canvas id="donut2" width="400" height="400"></canvas>
				</div>
			</div>
		</div>

	</div>	
</div>
<script>
$(document).ready(function () {
	var wallet = $('#wallet_id').val();
	
    $.ajax({
        url: 'getStatistics.html?wallet='+wallet,
        dataType: 'json', // not datatype
        type: "GET",
        beforeSend: function () {
            $(".loader").show();
        },
        success: function (json) {
        	charLoader(json)
        	donutLoader(json.versus[0],"donut1");
        	pieLoader(json.versusAll[0],"donut2");
        },
        error: function () {
            alert("error en la solicitud");
        },
        complete: function(){
            $(".loader").fadeOut("hide");

        }
    });


    function burbuja(miArray)
    {
        for(var i=1;i<miArray.length;i++)
        {
            for(var j=0;j<(miArray.length-i);j++)
            {
                if(miArray[j]>miArray[j+1])
                {
                    k=miArray[j+1];
                    miArray[j+1]=miArray[j];
                    miArray[j]=k;
                }
            }
        }
        return miArray;
    }

    function addDatesToLabel(label,array){
        for (a = 0; a < array.length; a++) {
            var exist = false;
            for (l = 0; l < label.length; l++) {
                if (label[l] == array[a].date)
                    exist = true;
            }
            if (!exist)
                label.push(array[a].date);
        }
        return label;
    }

    function addValuesToCurbe(label,data) {
        var array = [];
        for (l = 0; l < label.length; l++) {
            var value = 0;
            for (a = 0; a < data.length; a++) {
                if (label[l] == data[a].date){
                    value = data[a].quantity;
                    break;
                }
            }
            array.push(value);
        }
        return array;
    }

    function charLoader(data) {
        x_labels = [];
        ingresos = [];
        gastos = [];
        
        x_labels = addDatesToLabel(x_labels,data.ingresos);
        x_labels = addDatesToLabel(x_labels,data.gastos);
        x_labels = burbuja(x_labels);

        ingresos = addValuesToCurbe(x_labels,data.ingresos);
        gastos = addValuesToCurbe(x_labels,data.gastos);

        var lineChartData = {
            labels: x_labels,
            datasets: [
                {
                    label: "Ingresos",
                    fillColor: "rgba(76, 255, 81, .5)",
                    strokeColor: "rgba(76, 255, 81, 1)",
                    pointColor: "rgba(76, 255, 81, 1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(76, 255, 81, 1)",
                    data: ingresos
                },
                {
                    label: "Gastos",
                    fillColor: "rgba(255, 79, 76, .5)",
                    strokeColor: "rgba(255, 79, 76, .1)",
                    pointColor: "rgba(255, 79, 76, .1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(255, 79, 76, .1)",
                    data: gastos
                }
            ]
        };
        var ctx = document.querySelector("#line-chartjs").getContext("2d");
        window.myLine = new Chart(ctx,).Line(lineChartData, {
        		responsive: true,
            });
    }// FIN userCharLoader
    
    function donutLoader(data,canvasId){
    	var doughnutData = [{
	            value: data.totalGastos,
	            color: "rgba(250,133,100,1.0)",
	            highlight: "rgba(250,133,100,0.8)",
	            label: "Gastos"
	        }, {
	            value: data.totalIngresos,
	            color: "rgba(31,181,172,1)",
	            highlight: "rgba(31,181,172,0.8)",
	            label: "Ingresos"
	        }

    	];

	    var ctxd = document.getElementById(canvasId).getContext("2d");
	    window.myDoughnut = new Chart(ctxd).Doughnut(doughnutData, {
	        responsive: true
	    });
    }
    
    function pieLoader(data,canvasId){
    	var pieData = [{
	            value: data.totalGastos,
	            color: "rgba(211, 103, 154,1.0)",
	            highlight: "rgba(211, 103, 154,0.8)",
	            label: "Gastos"
	        }, {
	            value: data.totalIngresos,
	            color: "rgba(103, 210, 155,1)",
	            highlight: "rgba(103, 210, 155,0.8)",
	            label: "Ingresos"
	        }

    	];

	    var ctxd = document.getElementById(canvasId).getContext("2d");
	    window.myDoughnut = new Chart(ctxd).Pie(pieData, {
	        responsive: true
	    });
    }
    
});
</script>