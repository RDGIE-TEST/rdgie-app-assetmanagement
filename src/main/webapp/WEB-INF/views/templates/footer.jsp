


<script type="text/javascript" language="javascript" class="init">
	$(document).ready(function() {
		$('.datatableDisplay').dataTable();
		
		$('.datatableDisplay1').dataTable();
		
		$('.datatableDisplay2').dataTable();
			});
	
	
</script>

</div>

</body>
<script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
  </script>

<script>
	function getValues(checkedInputs, inputField, hiddenField, tableIndex) {
		var values = $('input:checkbox:checked.' + checkedInputs).map(
				function() {
					return this.value;
				}).get();
		var objectIds = "";
		for (id in values) {
			objectIds += values[id] + ",";
		}
		$("#" + hiddenField).val(objectIds.substring(0, objectIds.length - 1));
		
		var objectList = "";
		$('.datatableDisplay'+tableIndex+' tr').each(function() {

			if ($(this).find('input:checkbox').is(':checked')) {

				$(this).find('td').each(function() {
					if ($(this).hasClass('Phone'))
						objectList += "[" + $(this).text() + "]";
					else
						objectList += $(this).text() + " ";

				}); 
				objectList += ",";
			}
		});

		$("#" + inputField).val(objectList.substring(0, objectList.length - 1));
	}

	function underConstructionAlert(element) {
		alert("This " + element + " is under construction");
	}
</script>
</html>