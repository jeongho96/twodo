$(function(){
    $(document).ready(function(){
        $(".click-btn").on('click', function(e){
            console.log(e.target.id)

            var id = parseInt($(this).attr("prod-id"));
            if(confirm("ID:" + id + " DELETE?")) {
                location.href = '/main/blog/del/' + id;
            }
            else {
                return;
            }
            $.ajax({
                method:"DELETE",
                url: "/main/blog/del",
                data: JSON.stringify({
                    "id" : id
                }),
                contentType: "application/json"
            })
            .done(function(response){
                console.log("done");
                console.log(response);
                window.location.href = "/main";
            })
        });
    });
});