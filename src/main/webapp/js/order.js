
var global = 0;

function reserveTicket(seatId) {
    var seatDTO = {
        id: seatId,
        seanceId: $('#seance').val()
    };
    global++;
    console.log(global);

    document.getElementById('countTickets').outerHTML ='<input  id="countTickets" value="' +
        (Number($('#countTickets').val()) + 1) +'' +
        '"/>';
    $(this).removeClass('buttonForAddTicket').addClass('buttonForReservedTicket');

    $.ajax({
        url: '/addTicket?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(seatDTO),
        success: function (res) {
            parseResultFromDb(res);
            allSeats($('#seance').val());
        },
        error: function (err) {
            console.log(err);
        }
    })
};

function deleteTicket(seatId) {
    global--;
    console.log(global);
    document.getElementById('countTickets').outerHTML ='<input  id="countTickets" value="' +
        (Number($('#countTickets').val()) - 1) +'' +
        '"/>';
    $.ajax({
        url: '/ticket?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(seatId),
        success: function (res) {
            parseResultFromDb(res);
            allSeats($('#seance').val());
        },
        error: function (err) {
            console.log(err)
        }
    })
};

function allSeats(seanceId) {
    $.ajax({
        url: '/seats?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(seanceId),
        success: function (res) {
            redirectSeats(res, $('#columns').val());
        },
        error: function (err) {
            console.log(err);
        }
    });
};

function parseResultFromDb(res) {
    var ticketsFromDb = '';
    for (var i in res) {
        ticketsFromDb += '<div  class="cart_item">' +
            ' <div class="cart_item_data cart_item_data1"> <div class="top"> <p>ряд</p> </div> <div class="bottom"> <p> <strong>' +
            (res[i].coordinateRow + 1) +
            ' </strong> </p> </div> </div> <div class="cart_item_data cart_item_data2"> <div class="top"> <p>місце</p> </div> <div class="bottom"> <p> <strong>' +
            (res[i].coordinateColumn + 1) +
            '</strong> </p></div> </div> <div class="cart_item_data cart_item_data3"> <div class="top"> <p>ціна</p> </div> <div class="bottom"> <p> <strong>' +
            res[i].price +
            '</strong></strong><span>грн.</span></p> </div> </div> <div class="cart_item_data cart_item_data4"> <div class="top"> <p></p> </div> <div class="bottom"> <p><strong>' +
            (res[i].price * 10) +
            ' </strong><span>бонусів</span> </p> </div> </div> <div class="cart_item_data cart_item_data5"> ' +
            ' <button onclick="deleteTicket(' + res[i].id + ')">delete</button>' +
            '</div> </div>'
        '</div>';
    }

    document.getElementById('reservedTickets').innerHTML = ticketsFromDb;
    document.getElementById('numberTickets').innerHTML = 'квитки: ' + res.length;
    document.getElementById('totalPrice').innerHTML = '<p>' + priceTickets(res)+' грн.</p>';
    document.getElementById('totalBonus').innerHTML = '<p>або ' + ( priceTickets(res) * 10) + ' бонусів</p>';

};


function redirectSeats(res, columns) {
    var newTeg = ' <div class="seatRow">';
    var i = 0;
    var column = 0;
    var row = 0;
    newTeg += '<div class="seatRowNumber">Row' + (row++ + 1) + '</div>';
    for (i = 0; i < res.length; i++) {
        if (res[i].freeSeat) {
            if (!res[i].reservedSeat) {
                newTeg += '<div style="margin-right: 5px;" class=" seatNumber"> <button  onclick="reserveTicket(' +
                    res[i].id +
                    ' )" class="buttonForAddTicket">' +
                    (column + 1) +
                    '</button> </div>';
            } else {
                newTeg += '<div style="margin-right: 5px;" class=" seatNumber"> <button  class="buttonForReservedTicket">' +
                    (column + 1) +
                    '</button> </div>';
            }
        } else {
            newTeg += '<div style="margin-left: 11px; margin-right: 11px; "class=" seatUnavailable">' +
                (column + 1) +
                '</div>';
        }

        if (column == columns - 1) {
            newTeg += '</div>';
            if (i != res.length - 1) {
                newTeg += '<div class="seatRow">';
                newTeg += '<div class="seatRowNumber">Row ' + (row++ + 1) + ' </div>';
            }
            column = -1;
        }

        column++;
    }

    document.getElementById('seatsChart').innerHTML = newTeg;
};

/**
 *
 */
function  priceTickets (res) {
    var totalPrice = 0;
    for (var i in res){
        totalPrice += res[i].price;
    }
    return totalPrice;
};

// function countTickets() {
//     console.log('count' + $('#countTickets').val());
//     if ($('#countTickets') == 0 ) {
//         $("#tickets-buy-info").css("display", "inherit");
//         $("#tickets-buy-info").css("color", "red");
//         $("#btn-bye-tickets").attr('action', '#');
//     } else {
//         $("#btn-bye-tickets").attr('action', '#');
//         $("#tickets-buy-info").css("display", "none");
//     }
// };