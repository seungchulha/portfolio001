/*
Iamport PG / Verification System
reference : https://docs.iamport.kr/tech/mobile-authentication#add-library

verification related reference:
    https://github.com/iamport/iamport-manual/blob/master/SMS%EB%B3%B8%EC%9D%B8%EC%9D%B8%EC%A6%9D/README.md

Payment with Verification reference:
    https://github.com/iamport/iamport-manual/tree/master/%EC%9D%B8%EC%A6%9D%EA%B2%B0%EC%A0%9C

Iamport admin panel:
    https://admin.iamport.kr/users/login

 */

IMP.init('imp73093405');

IMP.certification({
    merchant_uid : 'merchant_' + new Date().getTime() //본인인증과 연관된 가맹점 내부 주문번호가 있다면 넘겨주세요
}, function(rsp) {
    if ( rsp.success ) {
        // 인증성공
        console.log(rsp.imp_uid);
        console.log(rsp.merchant_uid);

        $.ajax({
            type : 'POST',
            url : '/certifications/confirm',
            dataType : 'json',
            data : {
                imp_uid : rsp.imp_uid
            }
        }).done(function(rsp) {
            // 이후 Business Logic 처리하시면 됩니다.
        });

    } else {
        // 인증취소 또는 인증실패
        var msg = '인증에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;

        alert(msg);
    }
});