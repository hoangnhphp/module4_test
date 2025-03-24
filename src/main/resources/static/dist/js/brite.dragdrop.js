$(function () {
    'use strict';
    // preventing page from redirecting
    $("html").on("dragover", function(e) {
        e.preventDefault();
        e.stopPropagation();
    });

    $("html").on("drop", function(e) { e.preventDefault(); e.stopPropagation(); });

    // Drag enter
    $('.upload-area').on('dragenter', function (e) {
        e.stopPropagation();
        e.preventDefault();
    });

    // Drag over
    $('.upload-area').on('dragover', function (e) {
        e.stopPropagation();
        e.preventDefault();
    });

    // Drop
    $('.upload-area').on('drop', function (e) {
        e.stopPropagation();
        e.preventDefault();
        
        let files = e.originalEvent.dataTransfer.files;

        let result = getParamImageFromWrapper($(this));
        // function getAjaxUploadAvatar should be written individual in local file
        uploadFile (files, result[0], result[1]);
    });

});

function getParamImageFromWrapper(previewWrapper) 
{
    let image = previewWrapper.find('input').attr('name');
    let idImage = previewWrapper.find('input').attr('id');
    return [image, idImage];
}