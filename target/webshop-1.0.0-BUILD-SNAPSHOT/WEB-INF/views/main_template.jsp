<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
  <head>
    <title>WebShop</title>
    <link href="<s:url value="/resources" />/css/main.css" 
          rel="stylesheet" 
          type="text/css" />
  </head>

  <body>
    <div id="main">
      <a href="<s:url value="/home" />"><img 
          src="<s:url value="/resources" />/images/spitter_logo_50.png" 
          border="0"/></a>
      
      <div id="header">
        <t:insertAttribute name="header" />
	  </div>
	  <div id="topMenu">
		<t:insertAttribute name='topMenu'/>
	  </div>
	  <div id="wrapper">
	    <div class="content">
	      <div id="centerColumn">
	        <t:insertAttribute name='centerColumn'/>
	        <br>
	      </div>
	    </div>
	    <div id="leftColumn">
	      <t:insertAttribute name='leftColumn'/>
	    </div>
	    <iframe id="fcompare" name="fcompare" src="./TopmoBail_files/saved_resource.htm" scrolling="no" frameborder="0" style="position: absolute; left: -1000px; top: -1000px; z-index: 100; background-color: #FFF;"></iframe>
	    <div id="rightColumn">
	      <t:insertAttribute name='rightColumn'/>
	    </div>
	  </div>
	  <div id="footer">
	    <t:insertAttribute name='footer'/>
	  </div>
	  
    </div>
  </body>
</html>
