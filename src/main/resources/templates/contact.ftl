<#import "layout/default.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.default >

<#include "modul/navigation.ftl">

<div class="main">
    <div class="container">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="überschrift">
                <h3 class="text-center">Kontakt</h3>
            </div>
            <div class="panel-body">

                <p class="p--standard">
                    Holger Schulte<br/>
                    Holger Wollenberg<br/>
                    Filsum<br/>
                    E-Mail: <a href="mailto:filsumloeppt@gmail.com">filsumloeppt@gmail.com</a><br/>
                </p>

            </div>
        </div>


        <#include "/modul/sponsorList.ftl" />

</@layout.default>