<%@ include file="includes/header.jsp" %>

<div class="animated bounceInDown" style="font-size:32pt; font-family:arial; color:#990000; font-weight:bold">Document Comparison Service</div>

</p>&nbsp;</p>

<table style="width: 600; cellspacing: 2; border: 1">
	<tr style="margin: 10px">
		<td valign="top">

			<form bgcolor="white" method="POST" enctype="multipart/form-data" action="doProcess">
				<fieldset style="margin-left: 10px">
					<legend><h3>Specify Details</h3></legend>

					<b>Document Title :</b><br>
					<input name="txtTitle" type="text" size="50"/>
					<p/>
					<input type="file" name="txtDocument"/>
					<input type="submit" value="Compare Document">
				</fieldset>							
			</form>	

		</td>
	</tr>
</table>

<p>JEE Application for Measuring Document Similarity: enables two or more text documents to
be compared for similarity. Completed as part of 4th year module Advanced Object Oriented Programming.</p>
<p><em>Student: Rebecca Kane</em></p>

<%@ include file="includes/footer.jsp" %>

