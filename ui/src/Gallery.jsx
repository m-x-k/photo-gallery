import React from 'react';
import Gallery from 'react-photo-gallery';
import $ from 'jquery';
 
export default class DisplayPhotos extends React.Component {
    constructor(){
	    super();
		this.getPhotos(this);
	};

    getUrl(path) {
        if (DEV_MODE)
            return APP_URL + path;

        return window.location.href + path
    }

    getPhotos() {
        $.ajax({
          async:false,
          url: this.getUrl('/photo/list'),
          dataType: 'json',
          cache: false,
          success: function(data) {
          	this.photos = [];
			var i=0, photo, photos = data;
			while(photo = photos[i++]){
			    this.photos.push(this.displayPhoto(photo));
			}
          }.bind(this),
          error: function(xhr, status, err) {
            console.error(status, err.toString());
          }.bind(this)
        });
	}

	displayPhoto(photo) {
        let url = this.getUrl(photo.url);
        return {src: url, width: 100, height: 100, aspectRatio: 1, lightboxImage: { src: url, caption: photo.caption}};
	}

    render() {
      return (
          <Gallery photos={this.photos} />
      );
    }
}