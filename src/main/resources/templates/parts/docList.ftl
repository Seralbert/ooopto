<div>

<table class="table">
    <thead>
    <tr>
        <th>Краткое описание</th>
        <th>Ссылка на документ</th>
    </tr>
    </thead>

    <tbody>
<#list docs as doc>
<tr>
    <td>
        ${doc.discription}
    </td>
    <td>
        <a href="/docs/${doc.fileName}" target="_blank">Ссылка</a>
        <a href="./deleteDoc/${doc.id}">Удалить</a>
    </td>
</tr>
<#else>
<tr>
    <td>
        Нет документов
    </td>
</tr>
</#list>
    </tbody>
</table>
</div>