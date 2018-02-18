'use strict';

angular
    .module('app')
    .value('PageValues', {
        'title': null,
        'description': null,
        'loading': false,
        'countries':[]
    });