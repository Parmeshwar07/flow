'use strict';


angular.module('app').controller('NewEntryController', function ($scope) {
    var vm = this;
});


angular.module('app').controller('DuplicateEntryController', function ($scope) {
    var vm = this;
});

angular.module('app').controller('CreateEntryController', function ($scope,PageValues,entryservice) {
    var vm = this;
    vm.data = {};
    vm.submit = function (e) {
        //PageValues.loading = true;
        if ($("#create-entry-form")[0].checkValidity()){
            console.log(vm.data);
            entryservice.createEntry(vm.data,function (sucess,error) {
                console.log(sucess);
            });
        }
    }
});