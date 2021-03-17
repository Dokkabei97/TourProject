$(() => {
    $('#reviewF').on('submit', () => {
        if(!$('#content').val()) {
            alert('리뷰를 적어주세요');
            $('#content').focus();
            return false;
        }
        return true;
    })

})