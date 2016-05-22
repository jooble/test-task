function deleteById(id, name) {
    if (confirm("Are you sure you want to remove the " + name + "? \nID - " + id)) {
        $.ajax({
            type: "POST",
            url: contextPath + "/delete/" + name + "/" + id,
            success: function (result) {
                $("#" + name + "TrId" + id).remove();
            },
            error: function () {
                alert("Can`t delete " + name);
            }
        });
    }
}