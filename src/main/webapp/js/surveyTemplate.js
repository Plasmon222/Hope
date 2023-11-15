//0、获取携带入参url上的参数作为模版id
function getUrlParams() {
    var params = {};
    var queryString = window.location.search.substring(1);
    var keyValuePairs = queryString.split('&');

    for (var i = 0; i < keyValuePairs.length; i++) {
        var keyValue = keyValuePairs[i].split('=');
        params[decodeURIComponent(keyValue[0])] = decodeURIComponent(keyValue[1] || '');
    }

    return params;
}

var urlParams = getUrlParams();
sruveyIdValue = urlParams.surveyId;
console.log(sruveyIdValue);



console.log("1、调用ajax方法,获取数据。");
var surveyId = sruveyIdValue;
getFormat(sruveyIdValue);

//1、ajax请求url地址
function getFormat(surveyId) {
    console.log("surveyId=" + surveyId);
    $.ajax({
        // url: "http://localhost:8080/test1",
        url: "./getSurveyTemplate?surveyId="+surveyId,
        type: "POST",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        // data: JSON.stringify({ params: "{\"surveyId\":"+surveyId+"}"}),
        data: {
        },
        success: function (response) {
            console.log("2、调用surveyTemplateTest方法，进行模版设置");
            // console.log(response);
            surveyTemplateTest(response);
        },
        error: function (xhr, status, error) {
            console.error("Error: " + error);
        }
    });
}

// 2、调用surveyTemplateTest方法，进行模版设置
function surveyTemplateTest(result) {
    /**
     *  notesDate:注释
     columnTag:列名标记
     isSelect:是否必填 0必填 1选填
     boxType:输入框类型 0输入框 1单选框 2复选框
     boxDate:输入框内容
     columnName:问题
     */
    // console.log(result.beans);

    // 2.0.0 进行标题的设置
    function setTittle(Bt){
        var tittle1 = document.getElementById("tittle");
        tittle1.innerText=Bt;

        // $(document).ready(function(){
        //     $("#tittle").text(Bt);
        // });

    }



    // 2.1生成问题
    function columnNameF(columnName,isSelect) {
        var city = document.getElementById("city");
        // 向city中添加输入框
        if(isSelect==0){
            city.innerHTML += "<li><p class='question xrequired'>" + columnName + "</p></li>";
        }else{
            city.innerHTML += "<li><p class='question '>" + columnName + "</p></li>";
        }


    }

    // 2.2输入框类型选择
    function boxTypeF(boxType, boxDate, isSelect, columnTag,notesData) {
        console.log(columnTag+"---isSelect="+isSelect)
        // 向city中添加输入框
        var city = document.getElementById("city");
        //boxType:输入框类型 0输入框 1单选框 2复选框
        if (boxType == 1) {
            let arr = boxDate.split("；"); // 以逗号为分隔符截取字符串
            //console.log(arr); // 输出 ["apple", "banana", "orange"]
            //创建一个li (开口
            let li = document.createElement("li");
            city.innerHTML += "<li>";
            //创建一个 div  等下将div加入到li中
            let div = document.createElement("div");
            $.each(arr, function (index, value) {
                //向li中设置文本  class='inline-radio'  required
                if(isSelect==0){
                div.innerHTML +=
                    "<div class='inline-radio'>" +
                        "<label style=\"font-size: 20px;\">" +
                            "<input type='radio' required='required' style='width: 20px' name=qs" + columnTag + " value=" + value + ">"
                                + value +
                        "</label>" +
                    "</div>";
                }else{
                    div.innerHTML +=
                        "<div class='inline-radio'>" +
                        "<label style=\"font-size: 20px;\">" +
                        "<input type='radio' style='width: 20px' name=qs" + columnTag + " value=" + value + ">"
                        + value +
                        "</label>" +
                        "</div>";
                }
                //将li添加到city中
                li.appendChild(div);
            })
            city.appendChild(li);
            //封口
            city.innerHTML += "</li>";

        } else if (boxType == 2) {

            let arr = boxDate.split("；"); // 以逗号为分隔符截取字符串
            //console.log(arr); // 输出 ["apple", "banana", "orange"]
            //创建一个li 
            let li = document.createElement("li");
            city.innerHTML += "<li>";
            //创建一个 div  等下将div加入到li中
            let div = document.createElement("div");
            $.each(arr, function (index, value) {
                //向li中设置文本
                if(isSelect==0){div.innerHTML += "<div class='inline-radio'><label style=\"font-size: 20px;\"><input type='checkbox' required='required' style='width: 20px' name=qs" + columnTag + " value=" + value + ">"+ value+ "</label></div>";}
                else {div.innerHTML += "<div class='inline-radio'><label style=\"font-size: 20px;\"><input type='checkbox'  style='width: 20px' name=qs" + columnTag + " value=" + value + ">"+ value+ "</label></div>";}
                //将li添加到city中
                li.appendChild(div);
            })
            city.appendChild(li);
            city.innerHTML += "</li>";
        } else {
            //required
            if(isSelect==0){
                city.innerHTML += "<li><input class='box-out input-style'  type='text' required='required' name=qs" + columnTag + " placeholder=" + notesData + "></li>";
            }else {
                city.innerHTML += "<li><input class='box-out input-style'  type='text' name=qs" + columnTag + " placeholder=" + notesData + "></li>";
            }
        }
    }

    // 2.0 进行遍历准备设置问题
    var boxData, boxType, columnName, columnTag, isSelect, notesData,bt;
    //设置H1标题
    bt=result.object.surveyName;
    setTittle(bt);
    $.each(result.beans, function (index, value) {
        //2.1问题
        columnName = value.columnName;
        isSelect = value.isSelect;    //是否必填
        columnNameF(columnName,isSelect);
        //2.2问题格式
        boxData = value.boxData;      //选择框数据
        boxType = value.boxType;      //选择框类型
        columnTag = value.columnTag;  //第几个问题
        notesData = value.notesData;
        boxTypeF(boxType, boxData, isSelect, columnTag,notesData);
    });

}
//**验证必填项是否填写
const form=document.getElementById('myForm');
const submitButton=document.getElementById('submitButton');
submitButton.addEventListener('click',function (event){
    event.preventDefault(); //阻止默认的表单提交行为
    const requiredInputs =form.querySelectorAll('[required]');
    for (const input of requiredInputs){
        if(input.value.trim() ===''){
            staffNo("请填写必填项");
            // alert('请填写必填项');

            return;
        }
    }
    //如果所有必填项已填写，则执行后面的代码



    // form.submit();
    getFormData();
});
// 3、获得form表单内的数据
function getFormData() {
    var form = document.getElementById("myForm");
    var formData = new FormData(form);
    var inputParams = ""; //入参数据
    var columnContent;  //填写内容
    var ColumnTag = "";  //列名标记

    const map1 = new Map();
    for (var [key, value] of formData.entries()) {
        // console.log(key + ": " + value);
        if (map1.get(key)) {
            let zhongjian = map1.get(key) + "," + value;
            map1.set(key, zhongjian);
        } else {
            map1.set(key, value);
        }
    }

    // 3.1、校验手机号是否正确
    function isPhoneNumberValid(phoneNumber) {
        // 中国大陆手机号码正则表达式
        const reg = /^1[3-9]\d{9}$/;
        return reg.test(phoneNumber);
    }

    // 3.2生成要发送的答案
    //  答案本体
    var strData = "";
    var ii=1;
    for (const [key, value] of map1) {
        let va = `${value}`;
        strData =strData+ va+"" + "&&&";
        ColumnTag =ColumnTag+ii+"&&&";
        ii=ii+1;
    }

    // 去除末尾&&&
    columnContent = strData.replace(/(&&+)$/, '');
    ColumnTag = ColumnTag.replace(/(&&+)$/, '');
    console.log(strData)
    var inputs = form.getElementsByTagName("input");
    let phoneNum = inputs[0].value;
    if (isPhoneNumberValid(phoneNum)) {
        console.log("验证手机号成功===" + phoneNum)
        // 4、发送form表单数据给新建接口
        saveData(surveyId,columnContent,ColumnTag,phoneNum);
    } else {
        // alert("手机号码格式错误：" + phoneNum);
        staffNo("手机号码格式错误："+ phoneNum)
    }
}
//submitClick
function submitClick(){
    return false
}

// 4、发送form表单数据给新建接口
function saveData(surveyId,columnContent,columnTag,phoneNum) {
    console.log("准备发送的数据===" + JSON.stringify({"surveyId":surveyId,
        "columnContent":columnContent,
        "ColumnTag":columnTag,
        "phoneNum":phoneNum}))
    $.ajax({
        url: "http://localhost:8080/saveSurveyTemplateData",
        type: "POST",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            "surveyId":surveyId,
            "columnContent":columnContent,
            "ColumnTag":columnTag,
            "phoneNum":phoneNum
        }),
        // data: surveyId,
        success: function (response) {
            console.log("5、数据保存成功");
            console.log(response);
            // alert("数据保存成功");
            staffNo("数据保存成功")
            window.location="index.html"
        },
        error: function (xhr, status, error) {
            window.location="index.html"
            console.error("Error: " + error);
        }

    }

    );
}

//设置遮罩层
function staffNo(msg){
    $('#staff_no .yx_content-team').html(msg);
    $('#staff_no,.shadow').show();
    setTimeout(function (){
        $('#staff_no,.shadow').hide();
    },1500)
}


