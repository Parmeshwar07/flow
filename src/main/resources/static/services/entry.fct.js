'use strict';

/*
 * Contains a service to communicate with the TRACK TV API
 */
angular
    .module('app.services')
    .constant('API_KEY', '87de9079e74c828116acce677f6f255b')
    .factory('entryservice', entryservice);

function entryservice($http, API_KEY,$log) {
    var data = {
        'getUsers': getUsers,
        'createEntry':createEntry
    };

    function makeRequest(url,method,body,callback) {
        var requestUrl = "" + url;
        return $http({
            'url': requestUrl,
            'method':method,
            'data':body,
            'headers': {
                'Content-Type': 'application/json'
            },
            'cache': true
        }).then(function (response) {
            $log.info(response);
            callback(response.data);
        }).catch(dataServiceError);
    }

    function getUsers() {
        return makeRequest('data.json', []);
    }
    
    function createEntry(data,callback) {
        makeRequest("flow/add","POST",data,function (response) {
            callback(response);
        });
    }

    return data;

    function dataServiceError(errorResponse) {
        $log.error('XHR Failed for ShowService');
        $log.error(errorResponse);
        return errorResponse;
    }
}