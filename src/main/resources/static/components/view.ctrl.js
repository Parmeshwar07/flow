'use strict';
angular
    .module('app')
    .controller('ViewController', function($scope, PageValues) {
        //Setup the view model object
        var vm = this;
        vm.data = PageValues;
    });