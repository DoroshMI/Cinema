
var seance;


function deleteTicketFromInfo(seatId) {

    console.log(seatId);
    $.ajax({
        url: '/deleteTicketFromOrderREST?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(seatId),
        success: function (res) {
            parseResultFromDbInInfo(res);

        },
        error: function (err) {
            console.log(err)
        }
    })
};

function parseResultFromDbInInfo(res) {
    var ticketsFromDb = '';
    for (var i in res) {
        ticketsFromDb += '<div class="item" id="ticket"> <div class="pleace"> <p>ряд ' +
            (res[i].coordinateRow + 1) +
            ', місце ' +
            (res[i].coordinateColumn + 1) +
            '</p> </div> <div class="price" > <p> <strong>' +
            res[i].price +
            '.00 грн.</strong> </p> </div> <div class="comment" > <p> <strong>' +
            (res[i].price * 10) +
            ' бонусів</strong> </p> </div> <div  class="empty"> <button onclick="deleteTicketFromInfo(' +
            res[i].id +
            ')">delete </button> </div> </div>';
    }

    document.getElementById('ticket-container').innerHTML = ticketsFromDb;
    document.getElementById('totalBonus').innerHTML = 'Завтра тобі буде нараховано ' + priceTickets(res) + ' бонусів. За купівлю у RELUX бонуси не нараховуються';
    document.getElementById('totalPrice').innerHTML = 'Всього до сплати: ' + priceTickets(res) + ' грн.';

    if (res.length == 0) {
        $("#btn-buy-tickets").html("ОБРАТИ НОВІ МІСЦЯ");
        $("#hall-return").css("display", "none");
        $("#btn-buy-tickets").attr('onclick', '');
        $("#btn-buy-tickets").attr('href',
            ('/seances/' + seance.valueOf()).replace('amp;', ''));
    } else {
        document.getElementById('btn-buy-tickets').innerHTML = 'купити квитки за ' + priceTickets(res) + ' грн.';
    }


};

function priceTickets(res) {
    var totalPrice = 0;
    for (var i in res) {
        totalPrice += res[i].price;
    }
    return totalPrice;
};