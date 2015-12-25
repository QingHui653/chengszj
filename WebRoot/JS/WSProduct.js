$(function(){
		$("#discount").keyup( function() {
			
			 var price=$("#price").val();
				if(price!=''){
			 
			 var discount=$("#discount").val();
			 var dis=parseFloat(discount)/10;
			 var sum1 = parseFloat(price)*dis;
			 var sum=Math.round(sum1*100)/100;
			 if(!isNaN(sum)){
			 $("#disprice").val(sum);
				}
			 else{
				 $("#disprice").val(0);
			 }
			}
		});
		
		$("#price").keyup( function() {
			var discount=$("#discount").val();
			if(discount!=''){
			 var price=$("#price").val();
			 var dis=parseFloat(discount)/10;
			 var sum1 = parseFloat(price)*dis;
			 var sum=Math.round(sum1*100)/100;
			if(!isNaN(sum)){
			 $("#disprice").val(sum);
			}
			else{
				 $("#disprice").val(0);
				
			}
			}
		});
	
	
	
})


