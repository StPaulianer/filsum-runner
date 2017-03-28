<#macro default title="" flickr=false>
<!DOCTYPE html>
<html>
<head>
    <title>Filsum Loeppt</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8" />
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet"/>
    <link type="text/css" href="/css/bootstrap-theme.css" rel="stylesheet"/>
    <link type="text/css" href="/css/filsumrunner.css" rel="stylesheet"/>

    <link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
    <link rel="stylesheet" href="css/bootstrap-image-gallery.min.css">

    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-73847014-1', 'auto');
        ga('send', 'pageview');

    </script>
</head>
<body>
<div class="body">

    <#nested/>

<div class="container">
<div id="footer">


    <div class="footer-navi">
        <ul>
            <li class="first">Currently 1.1.0, 11.02.2017 </li>
            <li class="first"><a href="/impressum">Impressum</a></li>
            <li class="last"><a href="/dataprivacy">Datenschutzerklärung</li>
        </ul>
    </div>

</div>
</div>
</div>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript" src="/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="/js/jquery.tablesorter.widgets.min.js"></script>
<script type="text/javascript" src="/js/filsumrunner.js"></script>

<#if flickr>
    <script type="text/javascript" src="/js/filsumflickr.js"></script>
</#if>

<script src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
<script src="js/bootstrap-image-gallery.min.js"></script>



</body>
</html>
</#macro>