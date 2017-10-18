<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8" />
	<title>Kendo easy</title>

	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.common.min.css" />
	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.rtl.min.css" />
	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.silver.min.css" />
	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.mobile.all.min.css" />

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://kendo.cdn.telerik.com/2017.3.913/js/kendo.all.min.js"></script>
</head>

<body>

	<div id="grid"></div>
	<script>
		$(function () {

			var dataSource = new kendo.data.DataSource({
				transport: {
					read: {
						url: 'queryKendo.do',
						dataType: "json",
					},
					update: {
						url: 'updateKendo.do',
						dataType: "json",
						type: "POST",
						contentType:"application/json"			
					},
					destroy: {
						url: 'deleteKendo.do',
						dataType: "json",
						type: "POST",
						contentType:"application/json"
					},
					create: {
						url: 'insertKendo.do',
						dataType: "json",
						type: "POST",
						contentType:"application/json"
					},
					parameterMap: function (options, operation) { //定义提交给后台携带的参数  
						if (operation !== "read" && options) {
							var params = {
								id: options.models[0].id,
								name: options.models[0].name,
								age: options.models[0].age
							}
							var json = kendo.stringify(params);
							console.log(json);
							return json;
						}
					}
				},
				batch: true,
				pageSize: 5,
				schema: {
					type: "json",
				    id: "id",
					model: {
						id: "id",
						fields: {
							"id": {
								type: "number",
								nullable: true
							},
							"name": {
								type: "string",
								nullable: true,
								validation: {
									required: { message: "name is required" }
								}
							},
							"age": {
								type: "number",
								nullable: "true",
								validation: {
									required: { message: "age is required" }
								}
							}
						}
					}
				}
			});

			$("#grid").kendoGrid({
				columns: [
					{
						field: "id",
						width: 2
					},
					{
						field: "name",
						width: 5
					},
					{
						field: "age",
						width: 5
					},
					{
						field: "options",
						command: ["edit", "destroy"],
						width: 5
					}
				],
				dataSource: dataSource,
				pageable: {
					pageSize: 5,     // 一页显示多少行数据
					buttonCount: 5,  // 限制页数按钮的显示个数
					refresh: true,   // 是否允许刷新页面
					pageSizes: true, // 是否允许调整一页显示的行数，可设置[5, 10, 15]
				},
				page: function (e) {
					console.log(e.page);
				},
				editable: "inline",
				sortable: true,
				edit: function (e) {
					var numeric = e.container.find("input[name=id]").data("kendoNumericTextBox");
					numeric.enable(false);
					var editWindow = e.container.data("kendoWindow");
				},
				toolbar: ["create"]
			});
		});
	</script>
</body>

</html>