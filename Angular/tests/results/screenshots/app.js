var app = angular.module('reportingApp', []);

app.controller('ScreenshotReportController', function ($scope) {
    $scope.searchSettings = Object.assign({
        description: '',
        allselected: true,
        passed: true,
        failed: true,
        pending: true,
        withLog: true
    }, {}); // enable customisation of search settings on first page hit

    var initialColumnSettings = undefined; // enable customisation of visible columns on first page hit
    if (initialColumnSettings) {
        if (initialColumnSettings.displayTime !== undefined) {
            // initial settings have be inverted because the html bindings are inverted (e.g. !ctrl.displayTime)
            this.displayTime = !initialColumnSettings.displayTime;
        }
        if (initialColumnSettings.displayBrowser !== undefined) {
            this.displayBrowser = !initialColumnSettings.displayBrowser; // same as above
        }
        if (initialColumnSettings.displaySessionId !== undefined) {
            this.displaySessionId = !initialColumnSettings.displaySessionId; // same as above
        }
        if (initialColumnSettings.displayOS !== undefined) {
            this.displayOS = !initialColumnSettings.displayOS; // same as above
        }
        if (initialColumnSettings.inlineScreenshots !== undefined) {
            this.inlineScreenshots = initialColumnSettings.inlineScreenshots; // this setting does not have to be inverted
        }

    }


    $scope.inlineScreenshots = false;
    this.showSmartStackTraceHighlight = true;

    this.chooseAllTypes = function () {
        var value = true;
        $scope.searchSettings.allselected = !$scope.searchSettings.allselected;
        if (!$scope.searchSettings.allselected) {
            value = false;
        }

        $scope.searchSettings.passed = value;
        $scope.searchSettings.failed = value;
        $scope.searchSettings.pending = value;
        $scope.searchSettings.withLog = value;
    };

    this.isValueAnArray = function (val) {
        return isValueAnArray(val);
    };

    this.getParent = function (str) {
        var arr = str.split('|');
        str = "";
        for (var i = arr.length - 2; i > 0; i--) {
            str += arr[i] + " > ";
        }
        return str.slice(0, -3);
    };

    this.getSpec = function (str) {
        return getSpec(str);
    };


    this.getShortDescription = function (str) {
        return str.split('|')[0];
    };

    this.convertTimestamp = function (timestamp) {
        var d = new Date(timestamp),
            yyyy = d.getFullYear(),
            mm = ('0' + (d.getMonth() + 1)).slice(-2),
            dd = ('0' + d.getDate()).slice(-2),
            hh = d.getHours(),
            h = hh,
            min = ('0' + d.getMinutes()).slice(-2),
            ampm = 'AM',
            time;

        if (hh > 12) {
            h = hh - 12;
            ampm = 'PM';
        } else if (hh === 12) {
            h = 12;
            ampm = 'PM';
        } else if (hh === 0) {
            h = 12;
        }

        // ie: 2013-02-18, 8:35 AM
        time = yyyy + '-' + mm + '-' + dd + ', ' + h + ':' + min + ' ' + ampm;

        return time;
    };


    this.round = function (number, roundVal) {
        return (parseFloat(number) / 1000).toFixed(roundVal);
    };


    this.passCount = function () {
        var passCount = 0;
        for (var i in this.results) {
            var result = this.results[i];
            if (result.passed) {
                passCount++;
            }
        }
        return passCount;
    };


    this.pendingCount = function () {
        var pendingCount = 0;
        for (var i in this.results) {
            var result = this.results[i];
            if (result.pending) {
                pendingCount++;
            }
        }
        return pendingCount;
    };


    this.failCount = function () {
        var failCount = 0;
        for (var i in this.results) {
            var result = this.results[i];
            if (!result.passed && !result.pending) {
                failCount++;
            }
        }
        return failCount;
    };

    this.passPerc = function () {
        return (this.passCount() / this.totalCount()) * 100;
    };
    this.pendingPerc = function () {
        return (this.pendingCount() / this.totalCount()) * 100;
    };
    this.failPerc = function () {
        return (this.failCount() / this.totalCount()) * 100;
    };
    this.totalCount = function () {
        return this.passCount() + this.failCount() + this.pendingCount();
    };

    this.applySmartHighlight = function (line) {
        if (this.showSmartStackTraceHighlight) {
            if (line.indexOf('node_modules') > -1) {
                return 'greyout';
            }
            if (line.indexOf('  at ') === -1) {
                return '';
            }

            return 'highlight';
        }
        return true;
    };


    var results = [
    {
        "description": "Access page for viewing events|Testing Admin home functionality",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "2d1fb18f0896f2134593b3210e4f361b",
        "instanceId": 9812,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772112782,
                "type": ""
            }
        ],
        "screenShotFile": "003c003c-00b9-001c-0026-00b3009a008a.png",
        "timestamp": 1540772110568,
        "duration": 3885
    },
    {
        "description": "Access page for creating events|Testing Admin home functionality",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "2d1fb18f0896f2134593b3210e4f361b",
        "instanceId": 9812,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772115229,
                "type": ""
            }
        ],
        "screenShotFile": "00f800cd-0066-0049-00dc-00ac0096001d.png",
        "timestamp": 1540772114980,
        "duration": 1070
    },
    {
        "description": "Access page for managing events|Testing Admin home functionality",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "2d1fb18f0896f2134593b3210e4f361b",
        "instanceId": 9812,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772116674,
                "type": ""
            }
        ],
        "screenShotFile": "00340062-0094-00a4-00dd-0065005400d3.png",
        "timestamp": 1540772116416,
        "duration": 899
    },
    {
        "description": "should have a title|Testing Protractor functionality with homepage",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "737465ab63308ffdf4c71aa4a212bf6a",
        "instanceId": 15300,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772194731,
                "type": ""
            }
        ],
        "screenShotFile": "00d100d7-0061-00d9-005a-009700a30045.png",
        "timestamp": 1540772192344,
        "duration": 3084
    },
    {
        "description": "should login successfully|Testing homepage login",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "737465ab63308ffdf4c71aa4a212bf6a",
        "instanceId": 15300,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772196285,
                "type": ""
            }
        ],
        "screenShotFile": "00cf00d3-00e3-004b-00c1-00650036004c.png",
        "timestamp": 1540772196092,
        "duration": 962
    },
    {
        "description": "should login successfully using POM|Testing homepage login",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "737465ab63308ffdf4c71aa4a212bf6a",
        "instanceId": 15300,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772197621,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772197806,
                "type": ""
            }
        ],
        "screenShotFile": "00fb00f5-001b-008d-006d-00ee0014008b.png",
        "timestamp": 1540772197350,
        "duration": 1167
    },
    {
        "description": "should login successfully using POM efficiently|Testing homepage login",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "737465ab63308ffdf4c71aa4a212bf6a",
        "instanceId": 15300,
        "browser": {
            "name": "chrome",
            "version": "69.0.3497.100"
        },
        "message": "Passed",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772198998,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "http://18.220.118.195:8085/UnionFront/login - This page includes a password or credit card input in a non-secure context. A warning has been added to the URL bar. For more information, see https://goo.gl/zmWq3m.",
                "timestamp": 1540772199207,
                "type": ""
            }
        ],
        "screenShotFile": "007400ff-00f6-00c0-003f-00d7000800ab.png",
        "timestamp": 1540772198838,
        "duration": 966
    }
];

    this.sortSpecs = function () {
        this.results = results.sort(function sortFunction(a, b) {
    if (a.sessionId < b.sessionId) return -1;else if (a.sessionId > b.sessionId) return 1;

    if (a.timestamp < b.timestamp) return -1;else if (a.timestamp > b.timestamp) return 1;

    return 0;
});
    };

    this.sortSpecs();
});

app.filter('bySearchSettings', function () {
    return function (items, searchSettings) {
        var filtered = [];
        var prevItem = null;

        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            item.displaySpecName = false;

            countLogMessages(item);

            var hasLog = searchSettings.withLog && item.browserLogs && item.browserLogs.length > 0;
            if (searchSettings.description === '' ||
                (item.description && item.description.toLowerCase().indexOf(searchSettings.description.toLowerCase()) > -1)) {

                if (searchSettings.passed && item.passed || hasLog) {
                    checkIfShouldDisplaySpecName(prevItem, item);
                    filtered.push(item);
                    prevItem = item;
                } else if (searchSettings.failed && !item.passed && !item.pending || hasLog) {
                    checkIfShouldDisplaySpecName(prevItem, item);
                    filtered.push(item);
                    prevItem = item;
                } else if (searchSettings.pending && item.pending || hasLog) {
                    checkIfShouldDisplaySpecName(prevItem, item);
                    filtered.push(item);
                    prevItem = item;
                }

            }
        }

        return filtered;
    };
});

var isValueAnArray = function (val) {
    return Array.isArray(val);
};

var checkIfShouldDisplaySpecName = function (prevItem, item) {
    if (!prevItem) {
        item.displaySpecName = true;
        return;
    }

    if (getSpec(item.description) != getSpec(prevItem.description)) {
        item.displaySpecName = true;
        return;
    }
};

var getSpec = function (str) {
    var describes = str.split('|');
    return describes[describes.length - 1];
};

var countLogMessages = function (item) {
    if ((!item.logWarnings || !item.logErrors) && item.browserLogs && item.browserLogs.length > 0) {
        item.logWarnings = 0;
        item.logErrors = 0;
        for (var logNumber = 0; logNumber < item.browserLogs.length; logNumber++) {
            var logEntry = item.browserLogs[logNumber];
            if (logEntry.level === 'SEVERE') {
                item.logErrors++;
            }
            if (logEntry.level === 'WARNING') {
                item.logWarnings++;
            }
        }
    }
};
