'use strict';


angular.module('app').controller('CreateWorkflowController', function ($scope, PageValues) {
    var vm = this;
    vm.tabin = 1;
});


angular.module('app').controller('ExportWorkflowController', function ($scope, PageValues) {
    var vm = this;
    vm.tabin = 1;
});

angular.module('app').controller('ListWorkflowController', function ($scope, show, PageValues) {
    var vm = this;
    vm.list = show;
});

angular.module('app').controller('ViewWorkflowController', function ($scope, show, PageValues) {
    var vm = this;
    vm.tabin = 1;
    vm.flow = show;
});