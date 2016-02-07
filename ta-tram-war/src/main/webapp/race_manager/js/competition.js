function reloadCompetitions() {
    $.getJSON('/api/competitions')
    .done(function(data) {
        console.log(data);
        data.items.forEach(function(item, index) {
            $("#competitions").append('<tr><td onclick="loadCompetition(' + item.id + ')">' +
                item.title + '</td></tr>');
        });
    });
}

function loadCompetition(id) {
    $('#main_div').load('competition.html', function() {
        if ('' != id) {
            $('#createEventButton').removeAttr('disabled');
            reloadEvents(id);
            $.getJSON('/api/competitions/' + id)
            .done(function(response) {
                console.log(response.title);
                $('#comp_id').html(response.id);
                $('#comp_title').val(response.title);
            });
        }
        else {
            $('#createEventButton').attr('disabled', 'disabled');
        }
    });

}

function saveCompetition(id) {
    var createUrl = '/api/competitions' + ('' != id ? '' : '/' + id);
    var body = '{"title":"' + $('#comp_title').val() + '"}';
    $.ajax(createUrl,{
        method: 'POST',
        contentType: 'application/json',
        data: body,
        dataType: 'json'
    })
    .done(function(data) {
        console.log(data);
        $('#comp_id').html(data);
        $('#createEventButton').removeAttr('disabled');
    });
}
