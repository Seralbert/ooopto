<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">

    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th scope="col">Отдел</th>
            <th scope="col">Количество записей</th>
            <th scope="col">Количество образов</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>${r}</td><td>#{record}</td><td>${image}</td>
        </tr>
        <tr>
            <td>${r0}</td><td>#{record00}</td><td>${image00}</td>
        </tr>
        <tr>
            <td>${r1}</td><td>#{record01}</td><td>${image01}</td>
        </tr>
        <tr>
            <td>${r2}</td><td>#{record02}</td><td>${image02}</td>
        </tr>
        <tr>
            <td>${r3}</td><td>#{record03}</td><td>${image03}</td>
        </tr>
        <tr>
            <td>${r4}</td><td>#{record04}</td><td>${image04}</td>
        </tr>

        <tr>
            <td>${r5}</td><td>#{record05}</td><td>${image05}</td>
        </tr>
        <tr>
            <td>${r6}</td><td>#{record06}</td><td>${image06}</td>
        </tr>
        <tr>
            <td>${r7}</td><td>#{record07}</td><td>${image07}</td>
        </tr>
        <tr>
            <td>${r8}</td><td>#{record08}</td><td>${image08}</td>
        </tr>
        <tr>
            <td>${r9}</td><td>#{record09}</td><td>${image09}</td>
        </tr>
        <tr>
            <td>${r10}</td><td>#{record10}</td><td>${image10}</td>
        </tr>
        <tr>
            <td>${r11}</td><td>#{record11}</td><td>${image11}</td>
        </tr>
        <tr>
            <td>${r12}</td><td>#{record12}</td><td>${image12}</td>
        </tr>
        <tr>
            <td>${r13}</td><td>#{record13}</td><td>${image13}</td>
        </tr>
        <tr>
            <td>${r14}</td><td>#{record14}</td><td>${image14}</td>
        </tr>
        <tr>
            <td>${r15}</td><td>#{record15}</td><td>${image15}</td>
        </tr>
        <tr>
            <td>${r16}</td><td>#{record16}</td><td>${image16}</td>
        </tr>
        <tr>
            <td>${r17}</td><td>#{record17}</td><td>${image17}</td>
        </tr>
        <tr>
            <td>${r18}</td><td>#{record18}</td><td>${image18}</td>
        </tr>
        <tr>
            <td>${r19}</td><td>#{record19}</td><td>${image19}</td>
        </tr>
        <tr>
            <#assign countrec = record + record00 + record01 + record02 + record03 + record04
            + record05 + record06 + record07 + record08 + record09 + record10 + record11 + record12
            + record13 + record14 + record15 + record16 + record17 + record18 + record19
            >
            <#assign countimg = image + image00 + image01 + image02 + image03 + image04
            + image05  + image06 + image07 + image08 + image09 + image10  + image11 + image12
            + image13+ image14+ image15+ image16+ image17+ image18+ image19
            >

            <td><b>Всего</b></td><td><b>#{countrec}</b></td><td><b>#{countimg}</b></td>
        </tr>
        </tbody>
    </table>
</div>

</@c.page>
