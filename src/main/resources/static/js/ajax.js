$(function(){
$("#edit_button").click(function(){
    var id = $("#id").val();
    var subject = $("#edit_subject").val();
    var detail = $("#edit_detail").val();
    var target_date = $("#edit_target_date").val();
    alert(id);
    alert(subject);
    alert(detail);
    alert(target_date);
    $.ajax({
        method:"PUT",
        url:"/main/todo",
        data: JSON.stringify({
            "id" : id,
            "subject": subject,
            "detail": detail,
            "target_date": target_date
        }),
        contentType: "application/json"
    })
    .done(function(response){
        window.location.href = "/main/";
    })
})
}
);