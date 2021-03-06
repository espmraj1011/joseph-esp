<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monthly temperature</title>
</head>
<body>
<button>Get chart</button>

<div id="container"	 style="min-width:310px; height:400px; margin:0 auto"></div>

<script>
$(document).ready(function(){
	
	
    $("button").click(function(){
    	
    	
        $.ajax({url: "http://localhost:8080/RESTfulExample/rest/grouptemp/Temp", 
        	success: function(result){
        		console.log(result);
        		var seriesData = [];
        		var tmpData = {};
        		for(i=0;i<result.length;i++){
        			console.log(result[i].month);
        			tmpData = {
        					name : result[i].month_name,
        						data :[result[i].maxi]
        					}
        			seriesData.push(tmpData);
        		}
        		
        		console.log(seriesData);
        		
        		
        		Highcharts.chart('container', {
        		    chart: {
        		        type: 'column'
        		    },
        		    title: {
        		        text: 'Monthly Average Temperature'
        		    },
        		    subtitle: {
        		        text: 'Source: Worldclimate.com'
        		    },
        		    xAxis: {
        		        categories:[
        		                    'Month'
        		                ],
        		        crosshair: true
        		    },
        		    yAxis: {
        		        min: 0,
        		        title: {
        		            text: 'Temperature (Celcius)'
        		        }
        		    },
        		    tooltip: {
//         		        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
//         		        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
//         		            '<td style="padding:0"><b>{point.y:.2f}</b></td></tr>',
//         		        footerFormat: '</table>',
        		        shared: false,
        		        useHTML: true
        		    },
        		    plotOptions: {
        		        column: {
        		            pointPadding: 0.2,
        		            borderWidth: 0
        		        }
        		    },
        		    series: seriesData
        		});
        		
        		
        	},
        	error : function (a,b,c){
        		console.log(a,b,c);
        	}
        });
        
        
        
    });
    
    
    
});
</script>

</body>
</html>