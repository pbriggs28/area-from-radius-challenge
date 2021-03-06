<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Area from Radius</title>
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>  
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>

</head>
<body>

<springForm:form id="radiusForm" method="POST" cssClass="form-horizontal mx-auto" cssStyle="padding-top:200px">
    <div class="form-group">
        <label class="col-md-3 control-label">Radius</label>
        <div class="col-md-6">
        	<springForm:input path="radius" cssClass="form-control" />
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-9 col-md-offset-3">
            <div id="messages"><springForm:errors path="radius" cssClass="text-danger" /></div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-9 col-md-offset-3">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
    <c:if test="${not empty area}">
	    <div class="text-success text-center">The area is: ${area}</div>    
    </c:if>
</springForm:form>

<script>

<!-- Obviously in a real project this would be extracted out into js files -->

var notEmptyErrMsg = '${msgSrc.getMessage("NotNull.radius", null, null)}';
var numericErrMsg = '${msgSrc.getMessage("typeMismatch.radius", null, null)}';
var betweenErrMsg = '${msgSrc.getMessage("Min.radius", null, null)}';

$(document).ready(function() {
    $('#radiusForm').bootstrapValidator({
        container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            radius: {
                validators: {
                    notEmpty: {
                        message: notEmptyErrMsg
                    },
                    numeric: {
                    	message: numericErrMsg
                    },
                    between: {
                        min: 1,
                        max: 100,
                        message: betweenErrMsg
                    }
                }
            }
        }
    });
});
</script>

</body>
</html>