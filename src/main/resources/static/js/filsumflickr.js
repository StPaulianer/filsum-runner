$(document).ready(function() {
        getPicturesFromFlickr();
    }
);
function getPicturesFromFlickr() {

    var url = "https://api.flickr.com/services/rest/?method=flickr.photosets.getPhotos&api_key=be504ed1c19e2878dee74355ebd84136&photoset_id=72157682633987222&user_id=139699022%40N07&format=json&nojsoncallback=1&auth_token=72157683397577051-2464732c8c398f65&api_sig=8b4b164770edcf87c3d88d94217abc30";
    var src;
    $.getJSON(url, function(data){
        $.each(data.photoset.photo, function(i,item){
            var src_small = "http://farm"+ item.farm +".static.flickr.com/"+ item.server +"/"+ item.id +"_"+ item.secret +"_q.jpg";
            var src_big = "http://farm"+ item.farm +".static.flickr.com/"+ item.server +"/"+ item.id +"_"+ item.secret +"_b.jpg";
            //$("<img/>").attr("src", src).appendTo("<a data-gallery>").attr("href", src).attr("").appendTo("#imageslinks");
            $("<a href=" +src_big +" data-gallery> <img src=" +src_small + "> </a>").appendTo("#imageslinks");
        });
    });

}
