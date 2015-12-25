/****************************************
  选择单条，或者全选不选按钮的处理，控制 CheckBox
  的全选与取消全选
*****************************************/

  var  url="";
  var processUrl="";  //全局处理的url 用于增加修改查询预处理
  //全选
  function checkAll(selAll,sel) {      
	  var el = document.getElementsByTagName('input');    
	  var len = el.length; 
	  var val;   
	  for(var i=0; i<len; i++)   
	  {         
	  if((el[i].type=="checkbox") && (el[i].name==selAll))        
	   { el[i].checked = true; 
	   } 
	   if((el[i].type=="checkbox") && (el[i].name==sel))        
	   { el[i].checked = true; 
	   }
	       
	    } 
   
    } 
   
    //全不选  
    function clearAll(selAll,sel) {   
	    var el = document.getElementsByTagName('input');   
	      var len = el.length;    
	       for(var i=0; i<len; i++)  {        
	        if((el[i].type=="checkbox") && (el[i].name==selAll))         
	        {             
	        el[i].checked = false;         
	        } 
	        
	        if((el[i].type=="checkbox") && (el[i].name==sel))         
	        {             
	        el[i].checked = false;         
	        }
	    
	        } 
        } 
        //用于去掉全部选择checkbox
        function clearSelAll(selAll){   
	          var el = document.getElementsByTagName('input');   
	           var len = el.length;    
	          for(var i=0; i<len; i++)  {        
	        if((el[i].type=="checkbox") && (el[i].name==selAll) && (el[i].checked ==true))         
	        {             
	        el[i].checked = false;         
	        } 
	          } 
        }
         //获取checkbox 值
        function getUrl_delete(sel){
	         var el = document.getElementsByTagName('input');   
	         var len = el.length; 
	         var url="?";   
	        for(var i=0; i<len; i++)  {        
	        if((el[i].type=="checkbox") && (el[i].name==sel) && (el[i].checked==true))         
	        {             
	         url=url+el[i].value+"="+el[i].value+"&";         
	        } 
	        }  
	         return url.substring(0, url.length-1);   //去掉未尾的'&'
	          
        }
        //获取checkbox 值
        function getUrl_checkMore(sel){ 
	         var el = document.getElementsByTagName('input');   
	         var len = el.length; 
	         var url="";   
	        for(var i=0; i<len; i++)  {        
	        if((el[i].type=="checkbox") && (el[i].name==sel) && (el[i].checked==true))         
	        {             
	         url=el[i].value;         
	        } 
	        }  
	         return url;   //去掉未尾的'&'
	          
        }
        
         // 修改用 单行
       function only(sel,forward){   
       var el = document.getElementsByTagName('input');   
       var len = el.length; 
       var count=0;   
       for(var i=0; i<len; i++)  {        
        if((el[i].type=="checkbox") && (el[i].name==sel) && (el[i].checked==true))         
        {             
         count=count+1;         
        }     
         }
       /* if(count==0){
        alert("必须选择一项");
        return false;
        }
        if(count>1){
         alert("只能选择一项");
        return false;
        }*/
        if(count==1){
          //alert(forward+'||'+getUrl_checkMore(sel));
          processUrl=forward.replace("?id=","");
          alert(processUrl);
          sub();
         getList(actionUrl);
         return false;    //为false 才能跳转到window.location
        // window.location="form/updCategory.jsp" ;
        }
        return false;
       } 
       // 删除用 多行
       function more(sel,forward){    
	       var el = document.getElementsByTagName('input');   
	       var len = el.length; 
	       var count=0;   
	       for(var i=0; i<len; i++)  {        
	        if((el[i].type=="checkbox") && (el[i].name==sel) && (el[i].checked==true))         
	        {             
	         count=count+1;         
	        }     
	         }
	         processUrl=forward.replace("?id=","");
	         if(processUrl.indexOf('del')==0 ||processUrl.indexOf('Del')==0){ // 如果是删除操作做如下判断
			        if(count==0){
			        	if($('#recordid').val()==null ||$('#recordid').val()==""){
	        			 
				       		alert("没有选定记录，请双击选定某一条记录再进行删除操作，或者选定一条或者多条复选框再进行删除操作3");
							return false;
			      		  }
			        }
			        
			 }
	        if((count>=1)  && (window.confirm("您确定要进行此操作吗1？")==true)){
	      //  alert();
	         var url_d=getUrl_delete(sel);
	         json_alert(forward+"?"+url_d.substring(1,url_d.length));
	         getList(actionUrl);
	         
	          return false;
	        }
	        
	         if(($('#recordid').val()!=null ||$('#recordid').val()!="")  && (window.confirm("您确定要进行此操作吗2")==true)){ //处理双击选定情况
	        //  alert("d");
	         var url_d=$('#recordid').val()+'='+$('#recordid').val();
	         json_alert(forward+"?"+url_d);
	         getList(actionUrl);
	         
	          return false;
	        }
	        return false;
       } 
       
       
       // 无选择调用
       function not(url){    
         if(url=="print"){
           print();
         }else{
         processUrl=url;
         if(processUrl.indexOf('upd')==0 ||processUrl.indexOf('Upd')==0){ // 如果是查询就不刷新
			
		if($('#recordid').val()==null ||$('#recordid').val()==""){
			alert("没有选定记录，请双击某一条记录再进行修改操作");
			return false;
		}
		}
	         actionUrl=$('#actionUrl').val();;
	         sub();
	    if(processUrl.indexOf('find')==0 ||processUrl.indexOf('Find')==0){ // 如果是查询就不刷新
	    
	    }else{
	     getList(actionUrl);
	    }
        
       }
        
        return false;
       } 
       
       
       
  //全屏打开一个新窗口,屏蔽菜单栏、工具栏、地址栏、状态栏
	function openPageOnHead(url){
     var newwindow=window.open (url,'newwindow2','height=300, width=400, top=400, left=300, toolbar=no, menubar=no,scrollbars=no, resizable=no,location=no, status=no') //这句要写成一行
    return true;
	}
	
	 //双击查询详细信息
	function dclick(id){
		processUrl=biginUpdUrl; //biginUpdUrl 和修改按钮的url一样，都是修改action
		process(biginUpdUrl+'?isInit=y&id='+id);
		//window.location='UpdSys_System.action?id='+id;
	}
	function myFunction()
	{
	alert("Hello World!测试");
	return;
	}
        
    