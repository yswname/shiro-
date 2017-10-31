// JavaScript Document
$(document).ready(function(e) {
    // 给所有可以拖动的li添加draggable属性
	
	// 给所有可以移动的li绑定ondragstart事件
	var moveItem = document.getElementsByClassName('move');
    for (var i = 0; i < moveItem.length; i++) {
        moveItem[i].ondragstart = function (ev) {
            //dataTransfer.setData() 方法设置被拖数据的数据类型和值
            ev.dataTransfer.setData("Text", this.id);
        };
    }
	
	var moveContainer = document.getElementsByClassName("moveContainer");
	//alert(moveContainer.length);
	for(var i=0;i<moveContainer.length; i++){
		// 给可以接收拖放的父容器绑定ondragover事件
		moveContainer[i].ondragover= function (ev) {
            ev.preventDefault(); //阻止向上冒泡
        };
		// 给可以接收拖放的父容器绑定ondrop事件
		moveContainer[i].ondrop = function (ev) {
            ev.preventDefault();
            var id = ev.dataTransfer.getData('Text');
            this.appendChild(document.getElementById(id));
        }
	}
	
	//alert(19);
	
	
});
function toDelete(_id){
	var liObj = document.getElementById(_id);
	liObj.parentNode.removeChild(liObj);
}