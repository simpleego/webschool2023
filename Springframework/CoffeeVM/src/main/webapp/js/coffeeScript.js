
let products;
function loadProduct() {

	$.ajax({
		type: "get",
		async: false,
		dataType: "text",
		url: "http://localhost:8080/loadProduct.vm",
		success: function(data, textStatus) {
			products = JSON.parse(data);
			console.log(products);
			//console.log(products.products[0]);
			listProduct(products);
			checkButtons(0);
		},
		error: function(data, textStatus) {
			console.log("에러가 발생")
		},
		complete: function(data, textStatus) {
			console.log("전송 완료되었습니다.")
		}
	});
}


function returnCoins() {
	//  호출전 준비 작업				
	coinValue = coin;
	alert(coinValue);
	$.ajax({
		type: "get",
		async: false,
		dataType: "text",
		url: "http://localhost:8080/coins",
		data: { returncoin: "ret"  },
		success: function(data, textStatus) {
			console.log(data);
			$("#returnValue").val(data);
			$("#Valance").val(0);
		},
		error: function(data, textStatus) {
			console.log("에러가 발생")
		},
		complete: function(data, textStatus) {
			console.log("전송 완료되었습니다.")
		}
	});
}

function coffee(coffee_) {
	//  호출전 준비 작업	
	if (coffee_ === "밀크커피") {
		valance -= 300;
	} else if (coffee_ === "프림커피") {
		valance -= 300;
	} else if (coffee_ === "설탕커피") {
		valance -= 200;
	} else if (coffee_ === "블랙커피") {
		valance -= 200;
	}

	$("#valance").val(valance);
	checkButtons(valance);

	coffeeValue = coffee_;

	$.ajax({
		type: "get",
		async: false,
		dataType: "text",
		url: "http://localhost:8080/coffee.vm",
		data: {
			coffee: coffeeValue
		},
		success: function(data, textStatus) {
			console.log(data);
			const coffeeData = JSON.parse(data);

			const imgurl = 'images/' + coffeeData.coffee;
			$("#coffeeImg").attr("src", imgurl);

			const valance = coffeeData.valance;
			$("#valance").val(valance);
		},
		error: function(data, textStatus) {
			console.log("에러가 발생")
		},
		complete: function(data, textStatus) {
			console.log("전송 완료되었습니다.")
		}
	});
}

let valance = 0;
function coins(coin) {
	
	if(coin == 0){
		// 동전 반환 처리
		$("#returnValue").val(valance);
		valance = 0;
		$("#valance").val(valance);
		checkButtons(valance);
		return;
	}
	//  호출전 준비 작업				
	valance += coin;

	// 잔액표시
	$("#valance").val(valance);

	// 버튼상태 제어
	checkButtons(valance);
}

function checkButtons(valance) {	
	
	$(".product_button").each(function(index, item) {
		$(item).attr("disabled", true);
	});
	
	$(".product_button").each(function(index, item) {
	    console.log('price: '+products[index].pPrice)
		if(valance >= 300){
			if(products[index].pPrice == 300){
				$(item).attr("disabled", false);
			}
				
		}
		
		if (valance >= 200){			
			if(products[index].pPrice == 200){
				$(item).attr("disabled", false);
			}
		}
		
	});
	
}

function listProduct(products) {
	table_data = "";


	for (i = 0; i < 4; i++) {
		table_data += '<div class="product">';
		table_data += '<img class="product_img" src=' + products[i].pImageUrl + '><br>';
		table_data += '<span class="product_price">' + products[i].pPrice + '원</span><br>';
		table_data += '<input type="button"  class="product_button" value="' + products[i].pName + '" ><br>';
		table_data += '</div>';
	}

	$("#products").html(table_data);
	$("#products").css({ 'width': '400px', 'margin': '10px auto' });
	$(".product").css({ 'text-align': 'center', 'display': 'inline-block', 'width': '200px' });
	$(".product_button").css({ 'padding': '10px', 'margin-top': '10px' });
	$(".product_price").css({
		'padding': '10px',
		'border': '10px solid #fff',
		'background-color': '#ccc',
		'color': '#f00'
	});

	$(".product_button").each(function(index, item) {
		item.addEventListener('click', function(event) {
			coffee($(this).val());
		});
	});
}
