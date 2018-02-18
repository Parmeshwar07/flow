'use strict';

/*
 * Contains a service to communicate with the TRACK TV API
 */
angular
    .module('app.services')
    .constant('API_KEY', '87de9079e74c828116acce677f6f255b')
    .constant('BASE_URL', 'http://localhost:8084/worklow')
    .factory('userService', userservice);

function userservice($http, API_KEY, BASE_URL, $log) {
    var data = {
        'getUsers': getUsers
    };

    function makeRequest(url, params) {
        var requestUrl = "" + url + '?api_key=' + API_KEY;
        angular.forEach(params, function (value, key) {
            requestUrl = requestUrl + '&' + key + '=' + value;
        });
        return $http({
            'url': requestUrl,
            'method': 'GET',
            'headers': {
                'Content-Type': 'application/json'
            },
            'cache': true
        }).then(function (response) {
            return response.data;
        }).catch(dataServiceError);
    }

    function getUsers() {
        return makeRequest('data.json', []);
    }

    return data;

    function dataServiceError(errorResponse) {
        $log.error('XHR Failed for ShowService');
        $log.error(errorResponse);
        return errorResponse;
    }
}