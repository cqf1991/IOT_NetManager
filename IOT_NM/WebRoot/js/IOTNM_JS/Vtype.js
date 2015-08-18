
/*
 * 
 * 提供自定义的vtype
 */
Ext.apply(Ext.form.VTypes, {  
    phoneNumber:  function(v) {
        return /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/.test(v);
    },
    //验证失败信息  
    phoneNumberText: '请输入正确的电话格式', 
    phoneNumbernumMask:/[0-9_]/i,
    
    //
    alphanum:function(v)    
    {    
        return (/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(v));   //只含有汉字、数字、字母、下划线，下划线位置不限
    },    
    alphanumText:'请输入中文,字母,数字或者下划线.',   
    //IP地址
    IPaddress:function(v){
    	return (/(?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))/.test(v));
    },
    IPaddressText:'请输入正确的IP地址格式.如192.168.1.1',
  
    number:function(v){
    	return /^\d+(\.\d{1,1})?$/.test(v);

    },
    numberText:'请输入整数或精确到小数点后一位的小数',
    Mac:function(v){
    	return (/^([0-9a-fA-F]{2})(([/\s:-][0-9a-fA-F]{2}){5})$ /.test(v));
    },
    MacText:'请输入正确的Mac地址',
    
});  