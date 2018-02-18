'use strict';

/*
 * Contains a service to communicate with the TRACK TV API
 */
angular
    .module('app.services')
    .constant('API_KEY', '87de9079e74c828116acce677f6f255b')
    .constant('BASE_URL', 'http://localhost:8084/worklow/')
    .factory('worklowService', worklowServices);

function worklowServices($http, API_KEY, BASE_URL, $log) {
    var data = {
        'getList': getList,
        'getDetails': getDetails
    };

    function makeRequest(url, params) {
        var requestUrl = url + '?api_key=' + API_KEY;
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

    function getList(list) {
        console.log("listname", list);
        return makeRequest('flow-list.json', []);
    }
    function getDetails(list) {
        console.log("listname", list);
        return makeRequest('flow.json', []);
    }

    return data;

    function dataServiceError(errorResponse) {
        $log.error('XHR Failed for ShowService');
        $log.error(errorResponse);
        return errorResponse;
    }
}