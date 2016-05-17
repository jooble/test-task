function deleteCupboard(cupboardId) {
    if (confirm("Are you sure you want to remove the cupboard? \nID - " + cupboardId)) {
        $.ajax({
            type: "POST",
            url: "delete/cupboard/" + cupboardId,
            success: function (result) {
                $("#trCupboardId" + cupboardId).remove();
            },
            error: function () {
                alert("Can`t delete cupboard");
            }
        });
    }
}