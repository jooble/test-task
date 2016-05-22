function deleteById(id, name, url) {
    if (confirm("Are you sure you want to remove the " + name + "? \nID - " + id)) {
        $.ajax({
            type: "POST",
            url: "" + url,
            success: function (result) {
                $("#" + name + "TrId" + id).remove();
            },
            error: function () {
                alert("Can`t delete " + name);
            }
        });
    }
}