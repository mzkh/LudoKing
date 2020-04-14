package com.google.android.gms.games;

import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.tapjoy.TJAdUnitConstants;

public final class GamesClientStatusCodes extends CommonStatusCodes {
    public static final int ACHIEVEMENT_NOT_INCREMENTAL = 26562;
    public static final int ACHIEVEMENT_UNKNOWN = 26561;
    public static final int ACHIEVEMENT_UNLOCKED = 26563;
    public static final int ACHIEVEMENT_UNLOCK_FAILURE = 26560;
    public static final int APP_MISCONFIGURED = 26508;
    public static final int GAME_NOT_FOUND = 26509;
    public static final int INVALID_REAL_TIME_ROOM_ID = 26602;
    public static final int LICENSE_CHECK_FAILED = 26507;
    public static final int MATCH_ERROR_ALREADY_REMATCHED = 26595;
    public static final int MATCH_ERROR_INACTIVE_MATCH = 26591;
    public static final int MATCH_ERROR_INVALID_MATCH_RESULTS = 26594;
    public static final int MATCH_ERROR_INVALID_MATCH_STATE = 26592;
    public static final int MATCH_ERROR_INVALID_PARTICIPANT_STATE = 26590;
    public static final int MATCH_ERROR_LOCALLY_MODIFIED = 26597;
    public static final int MATCH_ERROR_OUT_OF_DATE_VERSION = 26593;
    public static final int MATCH_NOT_FOUND = 26596;
    public static final int MULTIPLAYER_DISABLED = 26583;
    public static final int MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 26580;
    public static final int MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE = 26582;
    public static final int MULTIPLAYER_ERROR_INVALID_OPERATION = 26584;
    public static final int MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 26581;
    public static final int NETWORK_ERROR_NO_DATA = 26504;
    public static final int NETWORK_ERROR_OPERATION_FAILED = 26506;
    public static final int OPERATION_IN_FLIGHT = 26607;
    public static final int PARTICIPANT_NOT_CONNECTED = 26603;
    public static final int REAL_TIME_CONNECTION_FAILED = 26600;
    public static final int REAL_TIME_INACTIVE_ROOM = 26605;
    public static final int REAL_TIME_MESSAGE_SEND_FAILED = 26601;
    public static final int REAL_TIME_ROOM_NOT_JOINED = 26604;
    public static final int SNAPSHOT_COMMIT_FAILED = 26573;
    public static final int SNAPSHOT_CONFLICT_MISSING = 26576;
    public static final int SNAPSHOT_CONTENTS_UNAVAILABLE = 26572;
    public static final int SNAPSHOT_CREATION_FAILED = 26571;
    public static final int SNAPSHOT_FOLDER_UNAVAILABLE = 26575;
    public static final int SNAPSHOT_NOT_FOUND = 26570;
    public static final int VIDEO_ALREADY_CAPTURING = 26625;
    public static final int VIDEO_NOT_ACTIVE = 26620;
    public static final int VIDEO_OUT_OF_DISK_SPACE = 26626;
    public static final int VIDEO_PERMISSION_ERROR = 26622;
    public static final int VIDEO_STORAGE_ERROR = 26623;
    public static final int VIDEO_UNEXPECTED_CAPTURE_ERROR = 26624;
    public static final int VIDEO_UNSUPPORTED = 26621;

    private GamesClientStatusCodes() {
    }

    public static int zzb(int i) {
        if (i == 1) {
            return 8;
        }
        if (i == 2) {
            return 26502;
        }
        if (i == 3) {
            return 26503;
        }
        if (i == 4) {
            return NETWORK_ERROR_NO_DATA;
        }
        if (i == 5) {
            return 26505;
        }
        if (i == 6) {
            return NETWORK_ERROR_OPERATION_FAILED;
        }
        if (i != 7) {
            if (i == 1500) {
                return 26540;
            }
            if (i == 1501) {
                return 26541;
            }
            switch (i) {
                case 7:
                    break;
                case 8:
                    return APP_MISCONFIGURED;
                case 9:
                    return GAME_NOT_FOUND;
                case TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL /*500*/:
                    return 26520;
                case GamesStatusCodes.STATUS_VIDEO_NOT_ACTIVE /*9000*/:
                    return VIDEO_NOT_ACTIVE;
                case GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED /*9001*/:
                    return VIDEO_UNSUPPORTED;
                case GamesStatusCodes.STATUS_VIDEO_PERMISSION_ERROR /*9002*/:
                    return VIDEO_PERMISSION_ERROR;
                case GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR /*9003*/:
                    return VIDEO_STORAGE_ERROR;
                case GamesStatusCodes.STATUS_VIDEO_UNEXPECTED_CAPTURE_ERROR /*9004*/:
                    return VIDEO_UNEXPECTED_CAPTURE_ERROR;
                case GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING /*9006*/:
                    return VIDEO_ALREADY_CAPTURING;
                case GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE /*9009*/:
                    return VIDEO_OUT_OF_DISK_SPACE;
                case 9010:
                    return 26627;
                case 9011:
                    return 26628;
                case 9012:
                    return 26629;
                case 9016:
                    return 26630;
                case 9017:
                    return 26631;
                case 9018:
                    return 26632;
                case 9200:
                    return 26650;
                case 9202:
                    return 26652;
                case 10000:
                    return 26700;
                case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                    return 26701;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    return 26702;
                default:
                    switch (i) {
                        case 1000:
                            return 26530;
                        case 1001:
                            return 26531;
                        case 1002:
                            return 26532;
                        case PointerIconCompat.TYPE_HELP /*1003*/:
                            return 26533;
                        case PointerIconCompat.TYPE_WAIT /*1004*/:
                            return 26534;
                        case 1005:
                            return 26535;
                        default:
                            switch (i) {
                                case 2000:
                                    return 26550;
                                case 2001:
                                    return 26551;
                                case 2002:
                                    return 26552;
                                default:
                                    switch (i) {
                                        case 3000:
                                            return ACHIEVEMENT_UNLOCK_FAILURE;
                                        case 3001:
                                            return ACHIEVEMENT_UNKNOWN;
                                        case 3002:
                                            return ACHIEVEMENT_NOT_INCREMENTAL;
                                        case 3003:
                                            return ACHIEVEMENT_UNLOCKED;
                                        default:
                                            switch (i) {
                                                case GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND /*4000*/:
                                                    return SNAPSHOT_NOT_FOUND;
                                                case GamesStatusCodes.STATUS_SNAPSHOT_CREATION_FAILED /*4001*/:
                                                    return SNAPSHOT_CREATION_FAILED;
                                                case GamesStatusCodes.STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE /*4002*/:
                                                    return SNAPSHOT_CONTENTS_UNAVAILABLE;
                                                case GamesStatusCodes.STATUS_SNAPSHOT_COMMIT_FAILED /*4003*/:
                                                    return SNAPSHOT_COMMIT_FAILED;
                                                case GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT /*4004*/:
                                                    return 26574;
                                                case GamesStatusCodes.STATUS_SNAPSHOT_FOLDER_UNAVAILABLE /*4005*/:
                                                    return SNAPSHOT_FOLDER_UNAVAILABLE;
                                                case GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT_MISSING /*4006*/:
                                                    return SNAPSHOT_CONFLICT_MISSING;
                                                default:
                                                    switch (i) {
                                                        case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED /*6000*/:
                                                            return MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED;
                                                        case 6001:
                                                            return MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER;
                                                        case 6002:
                                                            return MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE;
                                                        case 6003:
                                                            return MULTIPLAYER_DISABLED;
                                                        case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION /*6004*/:
                                                            return MULTIPLAYER_ERROR_INVALID_OPERATION;
                                                        default:
                                                            switch (i) {
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE /*6500*/:
                                                                    return MATCH_ERROR_INVALID_PARTICIPANT_STATE;
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH /*6501*/:
                                                                    return MATCH_ERROR_INACTIVE_MATCH;
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE /*6502*/:
                                                                    return MATCH_ERROR_INVALID_MATCH_STATE;
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /*6503*/:
                                                                    return MATCH_ERROR_OUT_OF_DATE_VERSION;
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /*6504*/:
                                                                    return MATCH_ERROR_INVALID_MATCH_RESULTS;
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED /*6505*/:
                                                                    return MATCH_ERROR_ALREADY_REMATCHED;
                                                                case GamesStatusCodes.STATUS_MATCH_NOT_FOUND /*6506*/:
                                                                    return MATCH_NOT_FOUND;
                                                                case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED /*6507*/:
                                                                    return MATCH_ERROR_LOCALLY_MODIFIED;
                                                                default:
                                                                    switch (i) {
                                                                        case 7000:
                                                                            return REAL_TIME_CONNECTION_FAILED;
                                                                        case 7001:
                                                                            return REAL_TIME_MESSAGE_SEND_FAILED;
                                                                        case 7002:
                                                                            return INVALID_REAL_TIME_ROOM_ID;
                                                                        case 7003:
                                                                            return PARTICIPANT_NOT_CONNECTED;
                                                                        case 7004:
                                                                            return REAL_TIME_ROOM_NOT_JOINED;
                                                                        case 7005:
                                                                            return REAL_TIME_INACTIVE_ROOM;
                                                                        case AdError.API_NOT_SUPPORTED /*7006*/:
                                                                            return 26606;
                                                                        case 7007:
                                                                            return OPERATION_IN_FLIGHT;
                                                                        default:
                                                                            switch (i) {
                                                                                case 8000:
                                                                                    return 26610;
                                                                                case 8001:
                                                                                    return 26611;
                                                                                case 8002:
                                                                                    return 26612;
                                                                                case 8003:
                                                                                    return 26613;
                                                                                default:
                                                                                    return i;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return LICENSE_CHECK_FAILED;
    }

    public static Status zza(int i) {
        return new Status(i, getStatusCodeString(i));
    }

    public static String getStatusCodeString(int i) {
        if (i == 26540) {
            return "PLAYER_OOB_REQUIRED";
        }
        if (i == 26541) {
            return "PLAYER_LEVEL_UP";
        }
        switch (i) {
            case 26502:
                return "CLIENT_RECONNECT_REQUIRED";
            case 26503:
                return "NETWORK_ERROR_STALE_DATA";
            case NETWORK_ERROR_NO_DATA /*26504*/:
                return "NETWORK_ERROR_NO_DATA";
            case 26505:
                return "NETWORK_ERROR_OPERATION_DEFERRED";
            case NETWORK_ERROR_OPERATION_FAILED /*26506*/:
                return "NETWORK_ERROR_OPERATION_FAILED";
            case LICENSE_CHECK_FAILED /*26507*/:
                return "LICENSE_CHECK_FAILED";
            case APP_MISCONFIGURED /*26508*/:
                return "APP_MISCONFIGURED";
            case GAME_NOT_FOUND /*26509*/:
                return "GAME_NOT_FOUND";
            case 26520:
                return "RESOLVE_STALE_OR_NO_DATA";
            case VIDEO_NOT_ACTIVE /*26620*/:
                return "VIDEO_NOT_ACTIVE";
            case VIDEO_UNSUPPORTED /*26621*/:
                return "VIDEO_UNSUPPORTED";
            case VIDEO_PERMISSION_ERROR /*26622*/:
                return "VIDEO_PERMISSION_ERROR";
            case VIDEO_STORAGE_ERROR /*26623*/:
                return "VIDEO_STORAGE_ERROR";
            case VIDEO_UNEXPECTED_CAPTURE_ERROR /*26624*/:
                return "VIDEO_UNEXPECTED_CAPTURE_ERROR";
            case VIDEO_ALREADY_CAPTURING /*26625*/:
                return "VIDEO_ALREADY_CAPTURING";
            case VIDEO_OUT_OF_DISK_SPACE /*26626*/:
                return "VIDEO_OUT_OF_DISK_SPACE";
            case 26627:
                return "VIDEO_NO_MIC";
            case 26628:
                return "VIDEO_NO_CAMERA";
            case 26629:
                return "VIDEO_SCREEN_OFF";
            case 26630:
                return "VIDEO_RELEASE_TIMEOUT";
            case 26631:
                return "VIDEO_CAPTURE_VIDEO_PERMISSION_REQUIRED";
            case 26632:
                return "CAPTURE_ALREADY_PAUSED";
            case 26650:
                return "VIDEO_MISSING_OVERLAY_PERMISSION";
            case 26652:
                return "VIDEO_CAPTURE_OVERLAY_VISIBLE";
            case 26700:
                return "CLIENT_LOADING";
            case 26701:
                return "CLIENT_EMPTY";
            case 26702:
                return "CLIENT_HIDDEN";
            default:
                switch (i) {
                    case 26530:
                        return "AUTH_ERROR_HARD";
                    case 26531:
                        return "AUTH_ERROR_USER_RECOVERABLE";
                    case 26532:
                        return "AUTH_ERROR_UNREGISTERED_CLIENT_ID";
                    case 26533:
                        return "AUTH_ERROR_API_ACCESS_DENIED";
                    case 26534:
                        return "AUTH_ERROR_ACCOUNT_NOT_USABLE";
                    case 26535:
                        return "AUTH_ERROR_ACCOUNT_UNICORN";
                    default:
                        switch (i) {
                            case 26550:
                                return "REQUEST_UPDATE_PARTIAL_SUCCESS";
                            case 26551:
                                return "REQUEST_UPDATE_TOTAL_FAILURE";
                            case 26552:
                                return "REQUEST_TOO_MANY_RECIPIENTS";
                            default:
                                switch (i) {
                                    case ACHIEVEMENT_UNLOCK_FAILURE /*26560*/:
                                        return "ACHIEVEMENT_UNLOCK_FAILURE";
                                    case ACHIEVEMENT_UNKNOWN /*26561*/:
                                        return "ACHIEVEMENT_UNKNOWN";
                                    case ACHIEVEMENT_NOT_INCREMENTAL /*26562*/:
                                        return "ACHIEVEMENT_NOT_INCREMENTAL";
                                    case ACHIEVEMENT_UNLOCKED /*26563*/:
                                        return "ACHIEVEMENT_UNLOCKED";
                                    default:
                                        switch (i) {
                                            case SNAPSHOT_NOT_FOUND /*26570*/:
                                                return "SNAPSHOT_NOT_FOUND";
                                            case SNAPSHOT_CREATION_FAILED /*26571*/:
                                                return "SNAPSHOT_CREATION_FAILED";
                                            case SNAPSHOT_CONTENTS_UNAVAILABLE /*26572*/:
                                                return "SNAPSHOT_CONTENTS_UNAVAILABLE";
                                            case SNAPSHOT_COMMIT_FAILED /*26573*/:
                                                return "SNAPSHOT_COMMIT_FAILED";
                                            case 26574:
                                                return "SNAPSHOT_CONFLICT";
                                            case SNAPSHOT_FOLDER_UNAVAILABLE /*26575*/:
                                                return "SNAPSHOT_FOLDER_UNAVAILABLE";
                                            case SNAPSHOT_CONFLICT_MISSING /*26576*/:
                                                return "SNAPSHOT_CONFLICT_MISSING";
                                            default:
                                                switch (i) {
                                                    case MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED /*26580*/:
                                                        return "MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED";
                                                    case MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*26581*/:
                                                        return "MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
                                                    case MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*26582*/:
                                                        return "MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE";
                                                    case MULTIPLAYER_DISABLED /*26583*/:
                                                        return "MULTIPLAYER_DISABLED";
                                                    case MULTIPLAYER_ERROR_INVALID_OPERATION /*26584*/:
                                                        return "MULTIPLAYER_ERROR_INVALID_OPERATION";
                                                    default:
                                                        switch (i) {
                                                            case MATCH_ERROR_INVALID_PARTICIPANT_STATE /*26590*/:
                                                                return "MATCH_ERROR_INVALID_PARTICIPANT_STATE";
                                                            case MATCH_ERROR_INACTIVE_MATCH /*26591*/:
                                                                return "MATCH_ERROR_INACTIVE_MATCH";
                                                            case MATCH_ERROR_INVALID_MATCH_STATE /*26592*/:
                                                                return "MATCH_ERROR_INVALID_MATCH_STATE";
                                                            case MATCH_ERROR_OUT_OF_DATE_VERSION /*26593*/:
                                                                return "MATCH_ERROR_OUT_OF_DATE_VERSION";
                                                            case MATCH_ERROR_INVALID_MATCH_RESULTS /*26594*/:
                                                                return "MATCH_ERROR_INVALID_MATCH_RESULTS";
                                                            case MATCH_ERROR_ALREADY_REMATCHED /*26595*/:
                                                                return "MATCH_ERROR_ALREADY_REMATCHED";
                                                            case MATCH_NOT_FOUND /*26596*/:
                                                                return "MATCH_NOT_FOUND";
                                                            case MATCH_ERROR_LOCALLY_MODIFIED /*26597*/:
                                                                return "MATCH_ERROR_LOCALLY_MODIFIED";
                                                            default:
                                                                switch (i) {
                                                                    case REAL_TIME_CONNECTION_FAILED /*26600*/:
                                                                        return "REAL_TIME_CONNECTION_FAILED";
                                                                    case REAL_TIME_MESSAGE_SEND_FAILED /*26601*/:
                                                                        return "REAL_TIME_MESSAGE_SEND_FAILED";
                                                                    case INVALID_REAL_TIME_ROOM_ID /*26602*/:
                                                                        return "INVALID_REAL_TIME_ROOM_ID";
                                                                    case PARTICIPANT_NOT_CONNECTED /*26603*/:
                                                                        return "PARTICIPANT_NOT_CONNECTED";
                                                                    case REAL_TIME_ROOM_NOT_JOINED /*26604*/:
                                                                        return "REAL_TIME_ROOM_NOT_JOINED";
                                                                    case REAL_TIME_INACTIVE_ROOM /*26605*/:
                                                                        return "REAL_TIME_INACTIVE_ROOM";
                                                                    case 26606:
                                                                        return "REAL_TIME_SERVICE_NOT_CONNECTED";
                                                                    case OPERATION_IN_FLIGHT /*26607*/:
                                                                        return "OPERATION_IN_FLIGHT";
                                                                    default:
                                                                        switch (i) {
                                                                            case 26610:
                                                                                return "MILESTONE_CLAIMED_PREVIOUSLY";
                                                                            case 26611:
                                                                                return "MILESTONE_CLAIM_FAILED";
                                                                            case 26612:
                                                                                return "QUEST_NO_LONGER_AVAILABLE";
                                                                            case 26613:
                                                                                return "QUEST_NOT_STARTED";
                                                                            default:
                                                                                return CommonStatusCodes.getStatusCodeString(i);
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static Status zzb(Status status) {
        int statusCode = status.getStatusCode();
        int zzb = zzb(statusCode);
        if (zzb == status.getStatusCode()) {
            return status;
        }
        if (GamesStatusCodes.getStatusString(status.getStatusCode()).equals(status.getStatusMessage())) {
            return new Status(zzb, getStatusCodeString(zzb), status.getResolution());
        }
        switch (statusCode) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
                return status;
            default:
                return new Status(zzb, status.getStatusMessage(), status.getResolution());
        }
    }
}
