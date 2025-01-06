package com.example.demo.constants;

import com.example.demo.constants.ConstErrorInfo;
import com.example.demo.util.MessageUtil;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ConstError {

    public static final ConstErrorInfo Ok = new ConstErrorInfo(200, "200", "OK");
    public static final ConstErrorInfo BadRequest = new ConstErrorInfo(400, "400", "Bad Request");
    public static final ConstErrorInfo Unauthorized =
            new ConstErrorInfo(401, "UNAUTHORIZED", "Unauthorized");
    public static final ConstErrorInfo Forbidden = new ConstErrorInfo(403, "403", "Forbidden");
    public static final ConstErrorInfo NotFound = new ConstErrorInfo(404, "404", "Not Found");

    public static final ConstErrorInfo validationFail =
            new ConstErrorInfo(406, "406", "Validation Fail");

    public static final ConstErrorInfo queryFail = new ConstErrorInfo(406, "406", "Query Fail");
    public static final ConstErrorInfo PreconditionFailed =
            new ConstErrorInfo(412, "412", "Precondition Failed");
    public static final ConstErrorInfo NoSession =
            new ConstErrorInfo(401, "SESSION_EXPIRED", "SESSION EXPIRE: NO SESSION");

    public static final ConstErrorInfo DataLimitExceedError(Object[] args) {
        return new ConstErrorInfo(
                200,
                "DATA_LIMIT_EXCEEDED",
                MessageUtil.getMessage("common.mybatis.max-row", args));
    }

    public static final ConstErrorInfo InternalServerError =
            new ConstErrorInfo(500, "500", "Internal Server Error");
    public static final ConstErrorInfo SQLException =
            new ConstErrorInfo(500, "500", "SQL Exception");
    public static final ConstErrorInfo ValidationFail =
            new ConstErrorInfo(500, "500", "Validation Fail");

    @UtilityClass
    public class Apply {
        public static final ConstErrorInfo success =
                new ConstErrorInfo(200, "AP.001.00", "정상적으로 처리되었습니다.");
        public static final ConstErrorInfo validationFail =
                new ConstErrorInfo(406, "AP.001.01", "validationFail");
        public static final ConstErrorInfo applyCreateFail =
                new ConstErrorInfo(407, "AP.002.01", "청약정보생성오류");
        public static final ConstErrorInfo reqSysTpCdFail =
                new ConstErrorInfo(409, "AP.002.02", "정의된 시스템이 아닙니다.");

        public static ConstErrorInfo existContFail(String apReqNo) {
            return new ConstErrorInfo(
                    409,
                    "AP.002.03",
                    "계약생성된 건입니다. 계약생성 이후는 서비스 해지 신청하시기 바랍니다.\n [청약요청 : " + apReqNo + "]");
        }

        public static ConstErrorInfo noApReqNoDataFail(String apReqNo) {
            return new ConstErrorInfo(
                    409, "AP.002.04", "취소 대상이 없습니다. 청약심사 요청번호를 확인해주세요.\n [청약요청 : " + apReqNo + "]");
        }

        public static ConstErrorInfo apprPrcsStFail(String apReqNo) {
            return new ConstErrorInfo(
                    409, "AP.002.05", "심사취소건은 취소할 수 없습니다.\n [청약요청 : " + apReqNo + "]");
        }

        public static ConstErrorInfo awaittingShippingFail(String apReqNo) {
            return new ConstErrorInfo(
                    409, "AP.002.06", "AWAITING SHIPPING건은 취소할 수 없습니다.\n [청약요청 : " + apReqNo + "]");
        }

        public static ConstErrorInfo erpOrdNoNotEmpty(String apReqNo) {
            return new ConstErrorInfo(
                    409, "AP.002.07", "수기 생성 계약요청의 경우만 취소 가능합니다.\n [청약요청 : " + apReqNo + "]");
        }

        public static final ConstErrorInfo safekeyUpdateFail =
                new ConstErrorInfo(409, "AP.002.08", "Safekey 정보가 취소처리 되지 않았습니다.");
        public static final ConstErrorInfo existCancelFail =
                new ConstErrorInfo(409, "AP.002.09", "이미 취소처리된 청약건입니다. ");

        public static ConstErrorInfo cancelfail(String apReqNo) {
            return new ConstErrorInfo(
                    409, "AP.002.10", "청약취소처리중 오류가 발생했습니다\n [청약요청 : " + apReqNo + "]");
        }

        public static ConstErrorInfo custLimitFail(String resnMsg) {
            return new ConstErrorInfo(409, "AP.002.11", "[주문제한 : " + resnMsg + "]");
        }

        public static ConstErrorInfo custNotValid =
             new ConstErrorInfo(409, "AP.002.12", "[개인] 필수입력값을 확인해주세요.");

        public static ConstErrorInfo custNotSafekey =
                new ConstErrorInfo(409, "AP.002.12", "[개인] SafeKey 가 없습니다.");

        public static ConstErrorInfo bizNotValid =
                new ConstErrorInfo(409, "AP.002.12", "[거래선] 필수입력값을 확인해주세요.");
    }

    @UtilityClass
    public class Contract {
        public static final ConstErrorInfo duplicated = new ConstErrorInfo(406, "TBD", "중복 계약 존재");
        public static final ConstErrorInfo majorIssueCust =
                new ConstErrorInfo(
                        409, "CT.000.01", "선택된 고객은 이슈 관리중인 고객입니다.\n이슈 처리 완료 후 해당 처리가 가능합니다.");
        public static final ConstErrorInfo validationFail =
                new ConstErrorInfo(422, "CT.000.02", "체크 조건이 올바르지 않습니다.");
        public static final ConstErrorInfo addTransferTypeFail =
                new ConstErrorInfo(409, "CT.000.03", "addTransferType 실패");
        public static final ConstErrorInfo getNewCmsCustFail =
                new ConstErrorInfo(409, "CT.000.04", "getNewCmsCustNo 실패");
        public static final ConstErrorInfo getCancelRequestListFail =
                new ConstErrorInfo(409, "CT.000.05", "유효하지 않은 해지접수 일괄요청순번입니다.");
        public static final ConstErrorInfo requestNullFail =
                new ConstErrorInfo(409, "CT.000.06", "처리를 위한 조건이 올바르지 않습니다.");
        // 계약요청
        public static final ConstErrorInfo checkForContNo =
                new ConstErrorInfo(409, "CT.200.01", "구독계약번호를 입력하세요");
        public static final ConstErrorInfo checkForValidation =
                new ConstErrorInfo(409, "CT.200.02", "조건을 하나 이상 입력하세요");
        public static final ConstErrorInfo contChgIns =
                new ConstErrorInfo(409, "CT.200.03", "계약변경생성시 에러가 발생하였습니다.");
        public static final ConstErrorInfo noServList =
                new ConstErrorInfo(409, "CT.200.04", "서비스목록이 필요합니다");
        public static final ConstErrorInfo chgReqSaveFail =
                new ConstErrorInfo(
                        409,
                        "CT.200.05",
                        """
                        계약요청 저장시 에러가 발생였습니다.
                        관리자에게 문의해주세요.
                        """);
        // 계약정산
        public static final ConstErrorInfo simulationDelFail =
                new ConstErrorInfo(409, "CT.202.01", "정산 table에 delete 에러가 발생하였습니다.");
        public static final ConstErrorInfo simulationInsertFail =
                new ConstErrorInfo(409, "CT.202.02", "정산 생성시 에러가 발생하였습니다.");
        public static final ConstErrorInfo contChgChek1 =
                new ConstErrorInfo(
                        409,
                        "CT.202.03",
                        """
                        요청 중인 계약변경 내역이 있습니다.
                        완료 후 진행해주세요.
                        """);

        // 계약관리
        public static ConstErrorInfo contChgConfirm(String appr) {
            String apprStts = "";
            if ("A".equals(appr)) {
                apprStts = "승인";
            } else if ("R".equals(appr)) {
                apprStts = "반려";
            } else {
                apprStts = "취소";
            }
            return new ConstErrorInfo(409, "CT.210.01", apprStts + "처리가 실패하었습니다.");
        }

        // 계약변경 end
        // 명의이전 start
        public static final ConstErrorInfo trfDupChk =
                new ConstErrorInfo(409, "CT.003.01", "명의이전 처리중 계약건입니다.");
        public static final ConstErrorInfo dupTrfExist =
                new ConstErrorInfo(409, "CT.003.02", "이미 진행 중인 명의이전 요청 건이 존재합니다.");
        public static final ConstErrorInfo unableTrfContTyCd =
                new ConstErrorInfo(409, "CT.003.03", "선택하신 계약은 명의이전 불가능한 계약유형입니다.");
        // 임시..삭제예정
        public static final ConstErrorInfo unableTrffulpay =
                new ConstErrorInfo(409, "CT.003.99", "선택하신 계약은 명의이전 불가능한 완납형입니다.");
        public static final ConstErrorInfo unableTrfContStatCd =
                new ConstErrorInfo(
                        409,
                        "CT.003.04",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 계약상태 확인""");
        public static final ConstErrorInfo unableTrfLongtmVist =
                new ConstErrorInfo(
                        409,
                        "CT.003.05",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 장기 미처리""");
        public static final ConstErrorInfo unableTrfMajorIssue =
                new ConstErrorInfo(
                        409,
                        "CT.003.06",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 3대이슈""");
        public static final ConstErrorInfo unableTrfReserve =
                new ConstErrorInfo(
                        409,
                        "CT.003.07",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 납부방법 변경 예약 존재""");
        public static final ConstErrorInfo unableTrfOverEarningAmt =
                new ConstErrorInfo(
                        409,
                        "CT.003.08",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 과납 존재""");
        public static final ConstErrorInfo unableTrfCms =
                new ConstErrorInfo(
                        409,
                        "CT.003.09",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : CMS 청구 진행중""");
        public static final ConstErrorInfo unableTrfCard =
                new ConstErrorInfo(
                        409,
                        "CT.003.10",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 카드 청구 진행중""");
        public static final ConstErrorInfo unableTrfCc =
                new ConstErrorInfo(
                        409,
                        "CT.003.11",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 쿠콘 청구 진행중""");
        public static final ConstErrorInfo unableTrfRcvGrpHeader =
                new ConstErrorInfo(
                        409,
                        "CT.003.12",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 청구그룹으로 채권생성예정. 그룹해제 후 진행 필요""");
        public static final ConstErrorInfo unableTrfOneYearPass =
                new ConstErrorInfo(
                        409,
                        "CT.003.13",
                        """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 계약시작 1년 미만""");
        public static final ConstErrorInfo insertNmtrMstFail =
                new ConstErrorInfo(409, "CT.003.14", "명의이전 마스터 저장중 오류가 발생하였습니다. 관리자에게 문의해주십시요.");
        public static final ConstErrorInfo insertNmtrDtlFail =
                new ConstErrorInfo(409, "CT.003.15", "명의이전 상세 저장중 오류가 발생하였습니다. 관리자에게 문의해주십시요.");
        public static ConstErrorInfo unableTrfeeContStatCd(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.16", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 계약상태 확인
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeNmtrStatCd(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.17", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 명의이전상태 확인
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeLongtmVist(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.18", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 장기 미처리
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeMajorIssue(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.19", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 3대이슈
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeReserve(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.20", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 납부방법 변경 예약 존재
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeCms(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.21", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : CMS 청구 진행중
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeCard(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.22", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 카드 청구 진행중
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeCc(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.23", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 쿠콘 청구 진행중
                                                                                (계약번호 """ + contNo +")");
        }
        public static ConstErrorInfo unableTrfeeRcvGrpHeader(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.003.23", """
                                                                                선택하신 계약은 명의이전 불가능한 상태입니다.
                                                                                사유 : 청구그룹으로 채권생성예정. 그룹해제 후 진행 필요
                                                                                (계약번호 """ + contNo +")");
        }
        // 명의이전 end

        public static final ConstErrorInfo postponeCust =
                new ConstErrorInfo(409, "TBD", "장기미처리 요청중인 항목입니다. 처리후 명의이전 하시기 바랍니다.");
        public static final ConstErrorInfo disableTransferStatus =
                new ConstErrorInfo(409, "TBD", "해지접수/만기완료/계약해지 상태는 명의이전을 할 수 없습니다.");
        public static final ConstErrorInfo disableTransferType =
                new ConstErrorInfo(
                        409,
                        "CT.003.03",
                        "자가계정/일시불/이벤트/일반판매무상케어/홈케어_토탈가전케어/요금완납형/계약그룹(묶음) 계약은 명의이전 처리 불가능합니다.");
        public static final ConstErrorInfo giftCardPayedCust =
                new ConstErrorInfo(409, "TBD", "해지방어 상품권 지급이력이 있습니다. 명의이전을 할 수 없습니다.");
        public static final ConstErrorInfo notExistTransfer =
                new ConstErrorInfo(409, "TBD", "이미 명의이전 처리 된 고객입니다.");
        public static final ConstErrorInfo updateContractReceiptFail =
                new ConstErrorInfo(409, "TBD", "updateContractReceipt 실패");
        public static final ConstErrorInfo insertTransferReceiptGroupInfoFail =
                new ConstErrorInfo(409, "TBD", "insertTransferReceiptGroupInfo 실패");
        public static final ConstErrorInfo unableTransferPerson =
                new ConstErrorInfo(409, "TBD", "고객유형이 고객일 경우 납부방법 무통장입금은 입력할 수 없습니다.");
        public static final ConstErrorInfo unableTransferBusiness =
                new ConstErrorInfo(409, "TBD", "고객유형이 거래선(개인사업자)일 경우 납부방법 무통장입금은 입력할 수 없습니다.");
        public static final ConstErrorInfo unableTransferBillingGrp =
                new ConstErrorInfo(409, "TBD", "청구그룹의 묶인 대표건입니다. 명의이전이 불가합니다");
        public static final ConstErrorInfo unableTransferBillingReserve =
                new ConstErrorInfo(409, "TBD", "납부방법 예약건이 존재합니다. 명의이전이 불가합니다");
        public static final ConstErrorInfo unableTransferOverBill =
                new ConstErrorInfo(409, "TBD", "과납이 존재하여 명의이전이 불가합니다");
        public static final ConstErrorInfo insertTaxivcGrpCopyFail =
                new ConstErrorInfo(409, "TBD", "insertTaxivcGrpCopy 실패");
        public static final ConstErrorInfo emptyCustInfo =
                new ConstErrorInfo(409, "TBD", "기존 고객 정보가 없습니다.");
        public static final ConstErrorInfo emptyForCreateCustInfo =
                new ConstErrorInfo(409, "TBD", "고객정보를 생성하기 위한 데이타가 존재하지 않습니다.");
        public static final ConstErrorInfo createReceiverFail =
                new ConstErrorInfo(409, "TBD", "인수자정보 생성중 오류가 발생하였습니다. 관리자에게 문의해주십시요.");
        public static final ConstErrorInfo updateContractReceiverFail =
                new ConstErrorInfo(409, "TBD", "계약의 인수자정보 변경중 오류가 발생하였습니다. 관리자에게 문의해주십시요.");


        public static ConstErrorInfo unableTransferRentalType(String limitDate) {
            return new ConstErrorInfo(
                    409,
                    "TBD",
                    String.format("구독 계약 후 1년 이내는 명의이전을 할 수 없습니다.(%s까지 명의이전 불가)", limitDate));
        }

        public static ConstErrorInfo notExistTransfer(String contHeaderSeq) {
            return new ConstErrorInfo(409, "TBD", "이미 요청된 정보가 있습니다. 계약라인번호 : " + contHeaderSeq);
        }

        /*------------------------------------------------------------------------------------------ */

        public static ConstErrorInfo emptyContNo() {
            return new ConstErrorInfo(409, "CT.004.01", "계약번호가 존재하지 않습니다.");
        }

        public static ConstErrorInfo billingGroupRepresentativeCase(String contNo) {
            return new ConstErrorInfo(
                    409, "CT.004.01", "청구그룹의 묶인 대표건입니다.\n [계약번호 : " + contNo + "]");
        }

        public static ConstErrorInfo emptyTermStdYmd(String contNo) {
            return new ConstErrorInfo(409, "CT.004.01", "해지기준일은 필수입니다.\n [계약번호 : " + contNo + "]");
        }

        public static ConstErrorInfo mustBeLessThanZero(String param, String contNo) {
            String koreanName = "";
            switch (param) {
                case "cmtmDiscntRfndAdjstAmt":
                    koreanName = "약정할인환불조정액";
                    break;
                case "combDiscntRfndAdjstAmt":
                    koreanName = "결합할인환불조정액";
                    break;
                case "giftClwbAdjstAmt":
                    koreanName = "사은품비환수금";
                    break;
                default:
                    break;
            }

            return new ConstErrorInfo(
                    409, "CT.004.01", koreanName + "은 0보다 클 수 없습니다..\n [계약번호 : " + contNo + "]");
        }

        public static ConstErrorInfo mustBeGreaterThanZero(String param, String contNo) {
            String koreanName = "";
            switch (param) {
                case "cmtmDiscntRfndCalcAmt":
                    koreanName = "약정할인환불조정액";
                    break;
                case "combDiscntRfndCalcAmt":
                    koreanName = "결합할인환불조정액";
                    break;
                case "giftClwbCalcAmt":
                    koreanName = "사은품비환수금";
                    break;
                case "giftcardCalcClwbAmt":
                    koreanName = "상품권반환금";
                    break;
                case "cshbkCalcClwbAmt":
                    koreanName = "캐시백환수금";
                    break;
                case "pntCalcClwbAmt":
                    koreanName = "포인트환수금";
                    break;
                case "pntCshAddCalcClwbAmt":
                    koreanName = "포인트현금추가환수금";
                    break;
                default:
                    break;
            }

            return new ConstErrorInfo(
                    409, "CT.004.01", koreanName + "은 0보다 작을 수 없습니다..\n [계약번호 : " + contNo + "]");
        }

        public static ConstErrorInfo changeRefundAmt(String refundColNm, String contNo) {
            String refundNm = "";
            switch (refundColNm) {
                case "cshbkClwbAmt":
                    refundNm = "캐시백 환수수금";
                    break;
                case "pntClwbAmt":
                    refundNm = "포인트 환수금";
                    break;
                case "pntCshAddClwbAmt":
                    refundNm = "포인트현금 환수금";
                    break;
                default:
                    break;
            }
            return new ConstErrorInfo(
                    409,
                    "CT.004.01",
                    refundNm + "이 변경되었습니다. 재조회 후 저장하세요.\n [계약번호 : " + contNo + "]");
        }

        public static ConstErrorInfo unableCareShipAndPrepayTermReceipt(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409,
                    "CT.004.01",
                    "계약유형이 케어십이고 선납할인인 경우 해지 접수 할 수 없습니다.\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static ConstErrorInfo retrieveCashbackContTermPossYn(
                String msg, String contHeaderSeq) {
            return new ConstErrorInfo(
                    409, "CT.004.02", msg + "\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static ConstErrorInfo existTermReceiptStatus(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409, "CT.004.03", "이미 해지접수 된 내역이 있습니다.\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static final ConstErrorInfo getRetriveApprovalFlagFail =
                new ConstErrorInfo(409, "CT.004.04", "해지접수 승인여부 조회 실패");

        public static final ConstErrorInfo getRetrieveReturnOrderInfoZipCdFail =
                new ConstErrorInfo(409, "CT.004.05", "대상데이터 추출에러");

        public static final ConstErrorInfo updateTermReturnOrderNoFail =
                new ConstErrorInfo(409, "CT.004.06", "XRMCT_TERM 회수주문 UPDATE 실패");

        public static final ConstErrorInfo insertTermAcceptHisFail =
                new ConstErrorInfo(409, "CT.004.07", "해지접수 이력저장 실패");

        public static ConstErrorInfo procSaveTbliOrgResFail(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409, "CT.004.08", "회수주문 저장 시 에러가 발생하였습니다.\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static ConstErrorInfo termReceiptApprovalFail =
                new ConstErrorInfo(409, "CT.004.09", "해지접수 승인처리 실패");

        public static ConstErrorInfo existTermCompleteStatus(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409, "CT.004.10", "이미 해지완료 된 내역이 있습니다.\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static ConstErrorInfo updateTermApprovalFlagFail(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409, "CT.004.11", "해지접수 승인처리 실패 :  [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static ConstErrorInfo termCompleteFail(String terminationSeq) {
            return new ConstErrorInfo(409, "CT.004.12", "해지완료 처리 실패:  " + terminationSeq);
        }

        public static ConstErrorInfo termReceiptRecoveryRequestHisFail =
                new ConstErrorInfo(409, "CT.004.13", "해지접수-회수요청 이력저장 실패");

        public static ConstErrorInfo serviceRunningContract(String contLineSeq) {
            return new ConstErrorInfo(
                    409,
                    "CT.004.14",
                    "서비스실행 중인 계약은 해지 접수 할 수 없습니다.\n [계약라인번호 : " + contLineSeq + "]");
        }

        public static ConstErrorInfo serviceRunningMsg(String msg, String contLineSeq) {
            return new ConstErrorInfo(409, "CT.004.15", msg + "\n [계약라인번호 : " + contLineSeq + "]");
        }

        public static ConstErrorInfo possibleCareShipAndCareTermReceipt(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409,
                    "CT.004.16",
                    "계약유형이 케어솔루션/케어일 경우만 해지접수 가능합니다.\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        public static ConstErrorInfo checkForMajorIssueCustomer =
                new ConstErrorInfo(
                        409, "CT.004.17", "선택된 고객은 이슈 관리중인 고객입니다.\n 이슈 처리 완료 후 해당 처리가 가능합니다.");

        public static ConstErrorInfo unableTermReceiptForContStatus(String contStatusNm) {
            return new ConstErrorInfo(409, "CT.004.18", contStatusNm + " 상태는 해지접수 할 수 없습니다.");
        }

        public static ConstErrorInfo saveCustomerPonctct(String contHeaderSeq) {
            return new ConstErrorInfo(
                    409, "CT.004.19", "고객접점 등록 시 오류가 발생하였습니다.\n [계약헤더번호 : " + contHeaderSeq + "]");
        }

        /*------------------------------------------------------------------------------------------ */

        public static final ConstErrorInfo checkForBatchFail =
                new ConstErrorInfo(409, "CT.005.01", "진행중인 배치가 있습니다.");
        public static final ConstErrorInfo checkForEvidenceFail =
                new ConstErrorInfo(409, "CT.005.02", "증빙파일이 존재하지 않습니다.");
        public static final ConstErrorInfo checkForChk07Null =
                new ConstErrorInfo(409, "CT.005.03", "일괄 해지접수 요청 처리를 위한 유효성검사에 실패했습니다.");
        public static final ConstErrorInfo checkForZipCd =
                new ConstErrorInfo(409, "CT.005.04", "물류 권역을 확인하기위한 우편번호 정보가 없습니다.");
        public static final ConstErrorInfo checkFileUploadId =
                new ConstErrorInfo(409, "CT.005.05", "첨부파일ID는 필수입니다.");
        public static final ConstErrorInfo checkContractTypeForCancelReq =
                new ConstErrorInfo(409, "CT.005.06", "계약유형이 일시불인 경우 해지접수를 할 수 없습니다.");
        public static final ConstErrorInfo checkMajorIssueForCancelReq =
                new ConstErrorInfo(409, "CT.005.07", "이슈관리고객 인 경우 해지접수를 할 수 없습니다.");

        public static ConstErrorInfo notValidHdrByStatus(String statusNm) {
            return new ConstErrorInfo(409, "CT.005.08", "(일괄요청) " + statusNm + "상태입니다.");
        }

        public static ConstErrorInfo notValidHdrByUserRes(String userRes) {

            return new ConstErrorInfo(
                    409, "CT.005.09", userRes == null ? "유효하지 않은 해지접수 일괄요청순번입니다." : userRes);
        }

        public static ConstErrorInfo checkRunningRefundInfo(String contHeaderSeq, int cnt) {

            return new ConstErrorInfo(
                    409,
                    "CT.005.10",
                    String.format(
                            "대상건에 환불진행중인 건이 있습니다. 환불이체완료처리 후 해지접수 하세요.\n"
                                    + "-----------------------------------------------------------\n"
                                    + "계약 번호:"
                                    + contHeaderSeq
                                    + "(환불진행중 %s건",
                            cnt));
        }

        public static ConstErrorInfo checkForChk07(String errMsg) {

            return new ConstErrorInfo(409, "CT.005.11", errMsg);
        }

        public static ConstErrorInfo checkForUpdateUserFail(String chk) {
            return new ConstErrorInfo(409, "CT.005.12", chk);
        }

        public static ConstErrorInfo contractStatusForCancelReq(String status) {
            return new ConstErrorInfo(
                    409, "CT.005.13", String.format("계약 ()" + status + ") 상태는 해지접수 할 수 없습니다."));
        }

        public static ConstErrorInfo checkServiceRunningMsg(String msg) {
            String str = "";
            if (msg == null || msg.isBlank()) {
                str = "서비스실행 중인 계약은 해지 접수 할 수 없습니다.";
            } else {
                str = msg;
            }
            return new ConstErrorInfo(409, "CT.005.14", str);
        }

        public static ConstErrorInfo checkSelfContractForCancelReq(String menuCd) {
            if (menuCd == "XRMCT7301") {
                return new ConstErrorInfo(
                        409, "CT.005.15", "계약유형이 케어솔루션인 경우에만 해지접수가 가능합니다. 자가계정 해지접수를 이용하세요");
            } else {
                return new ConstErrorInfo(409, "CT.005.16", "케어솔루션/케어십 해지접수를 이용하세요.");
            }
        }
    }

    @UtilityClass
    public class Customer {
        public static ConstErrorInfo mandatoryError(Object[] args) {
            return new ConstErrorInfo(
                    HttpStatus.NOT_ACCEPTABLE.value(),
                    "CS.000.00",
                    MessageUtil.getMessage("customer.validation.mandatory", args));
        }

        public static final ConstErrorInfo dlgtnDiffStatus =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.dlgtn.diff_status"));

        public static final ConstErrorInfo dlgtnSameStatus =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.dlgtn.same_status"));

        public static final ConstErrorInfo dlgtnFailEnd =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.dlgtn.fail_end"));

        public static final ConstErrorInfo dlgtnFailReq =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.dlgtn.fail_req"));

        public static final ConstErrorInfo dlgtnFailRreq =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.dlgtn.fail_rreq"));

        public static final ConstErrorInfo dlgtnFailNeReq =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.dlgtn.fail_ne_req"));

        public static final ConstErrorInfo majorIssuePrcsStatUnprocessed =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(), "TBD", "처리되지 않은 이슈 접수건이 존재합니다.");

        public static final ConstErrorInfo UnableToChangeForTaxInvoice =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        "매월 5일은 정기채권 전송으로 인해 세금계산서그룹 변경이 불가능합니다.");

        public static final ConstErrorInfo DuplicatedCustomerInfo =
                new ConstErrorInfo(
                        HttpStatus.NOT_ACCEPTABLE.value(),
                        "TBD",
                        MessageUtil.getMessage("customer.excl_cust.save_duplicate_fail"));
    }

    @UtilityClass
    public class Services {}
}
