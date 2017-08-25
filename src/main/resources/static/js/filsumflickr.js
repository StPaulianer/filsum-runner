$(document).ready(function() {
        getPicturesFromFlickr();
    }
);
function getPicturesFromFlickr() {

    var url = "https://api.flickr.com/services/rest/?method=flickr.photosets.getPhotos&api_key=e5084b29ab011cc87bfac3880ad61b61&photoset_id=72157682633987222&format=json&nojsoncallback=1";
    $.getJSON(url, function(data){
        $.each(data.photoset.photo, function(i,item){
            var src_small = "http://farm"+ item.farm +".static.flickr.com/"+ item.server +"/"+ item.id +"_"+ item.secret +"_q.jpg";
            var src_big = "http://farm"+ item.farm +".static.flickr.com/"+ item.server +"/"+ item.id +"_"+ item.secret +"_b.jpg";
            //$("<img/>").attr("src", src).appendTo("<a data-gallery>").attr("href", src).attr("").appendTo("#imageslinks");
            $("<a href=" +src_big +" data-gallery> <img src=" +src_small + "> </a>").appendTo("#imageslinks");
        });
    });

}
