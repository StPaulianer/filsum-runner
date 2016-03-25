$(document).ready(function() {
        getPicturesFromFlickr();
    }
);
function getPicturesFromFlickr() {

    var url = "https://api.flickr.com/services/rest/?method=flickr.photosets.getPhotos&api_key=73144cfb5c4856b2ec9657674fcadc69&user_id=139699022@N07&format=json&photoset_id=72157663983567746";
    var src;
    $.getJSON(url + "&format=json&jsoncallback=?", function(data){
        $.each(data.photoset.photo, function(i,item){
            var src_small = "http://farm"+ item.farm +".static.flickr.com/"+ item.server +"/"+ item.id +"_"+ item.secret +"_q.jpg";
            var src_big = "http://farm"+ item.farm +".static.flickr.com/"+ item.server +"/"+ item.id +"_"+ item.secret +"_b.jpg";
            //$("<img/>").attr("src", src).appendTo("<a data-gallery>").attr("href", src).attr("").appendTo("#imageslinks");
            $("<a href=" +src_big +" data-gallery> <img src=" +src_small + "> </a>").appendTo("#imageslinks");
        });
    });

}
