<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="jumbotron homecontainer">
            <div class="container">
                <img class="logo img-responsive center-block" src="../../images/logo_filsum_loeppt.gif">
                <h3 class="text-center">30. Juni 2017</h3>
                <p><a class="btn btn-primary btn-lg center-block btn-filsum" href="/register" role="button">Anmelden</a></p>
            </div>
        </div>

        <#include "/modul/sponsorList.ftl" />


    </div>
</div>

<script>
    setInterval(function() {
        window.location.reload();
    }, 12000000);
</script>
</@layout.default>