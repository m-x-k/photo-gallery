import React from 'react';
import Gallery from 'react-photo-gallery';
import $ from 'jquery';
 
export default class DisplayPhotos extends React.Component {
    constructor(){
	    super();
		this.getPhotos(this);
	};

	getPhotos() {
        $.ajax({
          async:false,
          url: 'http://localhost:8081/photo/list',
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
         return {src: photo.url, width: 100, height: 100, aspectRatio: 1, lightboxImage: { src: photo.url, caption: photo.caption}};		
	}

    render() {
      return (
          <Gallery photos={this.photos} />
      );
    }
}