
function calculate(operation) {
    const num1 = parseFloat(document.getElementById("num1").value);
    const num2 = parseFloat(document.getElementById("num2").value);
    const operatorElement = document.getElementById("operator");
    const resultElement = document.getElementById("result");

    if (isNaN(num1) || isNaN(num2)) {
        resultElement.innerText = "Please enter valid numbers!";
        return;
    }

    let result;
    if (operation === "add") {
        result = num1 + num2;
        operatorElement.innerText = "+";
    } else if (operation === "sub") {
        result = num1 - num2;
        operatorElement.innerText = "-";
    }

    resultElement.innerText = "Result: " + result;
}

function resetFields() {
    document.getElementById("num1").value = "";
    document.getElementById("num2").value = "";
    document.getElementById("operator").innerText = "";
    document.getElementById("result").innerText = "Result:";
}
