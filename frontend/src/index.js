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
        operatorElement.innerText = "+";
        fetch(`http://localhost:8080/add?num1=${num1}&num2=${num2}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('result').innerText = "Result: " + data.result;
        })
        .catch(err => {
            console.log(err);
        });
    } else if (operation === "sub") {
        operatorElement.innerText = "-";
        fetch(`http://localhost:8080/sub?num1=${num1}&num2=${num2}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('result').innerText = "Result: " + data.result;
        })
        .catch(err => {
            console.log(err);
        });
    }

    resultElement.innerText = "Result: " + result;
}

function resetFields() {
    document.getElementById("num1").value = "";
    document.getElementById("num2").value = "";
    document.getElementById("operator").innerText = "";
    document.getElementById("result").innerText = "Result:";
}