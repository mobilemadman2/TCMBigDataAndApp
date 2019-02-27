/**
 * 
 *
 */﻿﻿﻿﻿﻿require.config({
  //urlArgs: "version=20170407",
  paths: {
	'jquery' : '/js/packages/jquery-3.3.1',
	'bootstrap' : '/bootstrap/js/bootstrap.min',
    'jquery_page':"/js/packages/jquery.twbsPagination",    
  },
  shim: {
    'bootstrap': {
      deps: ['jquery'],
      exports: 'bootstrap'
    },
  	'jquery_page':{
  		deps: ['jquery'],
        exports: 'bootstrap'
  	}
  }
});

require(['jquery','bootstrap','jquery_page'], function ($) {
	
	getDisease()
	getMaterial()
	getPrescription()
	getYian()
	getCelebrity()
	getSyndrome()

	function getSyndrome(){
		var disease_id = [15772,15771,15779,15802,15806,15839,15881,15899,15999,16077]
		var disease_name = ['血脱证','血虚津亏证','亡阴证','外风证','风重于热证','外燥证','气滞证','火毒流窜证','心阳虚脱证','脾气不固证']
		for(var i=0;i<10;i++){
			var disease_span = document.createElement("span");
			disease_span.setAttribute("class","list-item")

			var disease_anchor = document.createElement("a");
			disease_anchor.setAttribute("href","/syndrome/info.html?syndromeId="+disease_id[i]);
			disease_anchor.innerHTML = disease_name[i];
			
			disease_span.appendChild(disease_anchor)
			
			$("#syndrome-recommend").append(disease_span);
		}
	}

	function getCelebrity(){
		var disease_id = [422,58,3963,8390,8422,3996,2145,7645,8557,2883]
		var disease_name = ['黄帝','岐伯','神农','扁鹊','张仲景','孙思邈','傅山','李时珍','巢元方','朱震记']
		for(var i=0;i<10;i++){
			var disease_span = document.createElement("span");
			disease_span.setAttribute("class","list-item")

			var disease_anchor = document.createElement("a");
			disease_anchor.setAttribute("href","#");
			disease_anchor.innerHTML = disease_name[i];
			
			disease_span.appendChild(disease_anchor)
			
			$("#celebrity-recommend").append(disease_span);
		}
	}
	
	function getYian(){
		var disease_id = [422,58,3963,8390,8422,3996,2145,7645,8557,2883]
		var disease_name = ['医案1','医案2','医案3','医案4','医案5','医案6','医案7','医案8','医案9','医案10']
		for(var i=0;i<10;i++){
			var disease_span = document.createElement("span");
			disease_span.setAttribute("class","list-item")

			var disease_anchor = document.createElement("a");
			disease_anchor.setAttribute("href","#");
			disease_anchor.innerHTML = disease_name[i];
			
			disease_span.appendChild(disease_anchor)
			
			$("#yian-recommend").append(disease_span);
		}
	}
	
	
	function getPrescription(){
		var disease_id = [355013,332875,357292,360324,314233,340641,355959,338166,323451,359624]
		var disease_name = ['麻黄汤','桂枝汤','桑菊饮','银翘散','白虎汤','黄连解毒汤','清胃散','藿香正气散','大柴胡汤','逍遥散']
		for(var i=0;i<10;i++){
			var disease_span = document.createElement("span");
			disease_span.setAttribute("class","list-item")

			var disease_anchor = document.createElement("a");
			disease_anchor.setAttribute("href","/prescription/info.html?prescriptionId="+disease_id[i]);
			disease_anchor.innerHTML = disease_name[i];
			disease_span.appendChild(disease_anchor)
			
			$("#prescription-recommend").append(disease_span);
		}
	}
	

	//----------------------------------------------
	function getDisease(){
		var disease_id = [84, 1002, 70, 67, 925, 1167, 605, 117, 1274, 1233]
		var disease_name = ['普通感冒','咳嗽','痛经','高血压病','乙型肝炎','肝癌','肺癌','冠心病','肺炎','心绞痛']
		for(var i=0;i<10;i++){
			var disease_span = document.createElement("span");
			disease_span.setAttribute("class","list-item")

			var disease_anchor = document.createElement("a");
			disease_anchor.setAttribute("href","/disease/info.html?diseaseId="+disease_id[i]);
			disease_anchor.innerHTML = disease_name[i];
			
			disease_span.appendChild(disease_anchor)
			
			$("#disease-recommend").append(disease_span);
		}
	}
	
	function getMaterial(){
		var disease_id = [422,58,3963,8390,8422,3996,2145,7645,8557,2883]
		var disease_name = ['人参','三七','灵芝','鹿茸','麝香','燕窝','山药','阿胶','黄芪','枸杞子']
		for(var i=0;i<10;i++){
			var disease_span = document.createElement("span");
			disease_span.setAttribute("class","list-item")

			var disease_anchor = document.createElement("a");
			disease_anchor.setAttribute("href","/material/info.html?materialId="+disease_id[i]);
			disease_anchor.innerHTML = disease_name[i];
			
			disease_span.appendChild(disease_anchor)
			
			$("#material-recommend").append(disease_span);
		}
	}
	
	
	
	//----------------------------------------------
});
