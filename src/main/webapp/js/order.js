$('#addTicket').click(function () {
    var seat = {
        id : $('#seatId').val()
    }

    $.ajax({
        url: '/addTicket?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(seat),
        success: function (res) {
            res.console.log(res)
            // parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })
})