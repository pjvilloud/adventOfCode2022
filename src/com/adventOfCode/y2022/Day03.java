package com.adventOfCode.y2022;

import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public static final String TEST_INPUT = """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw""";

    public static final String INPUT = """
            jLnFTjhwFTLFDGDDvLgvDssBJBbVRNZJPPJBGzBNRVJNRB
            QWmffSmMZCfWrmHlCflQWfSNBpVBNbPSbbJNppcVVzzpcp
            lflrqrWMmfdMlrtWWmZgDjsqwFwhFDsngnvhqs
            CNBGwsWVsdWDNCCVvfPLfQfgZHPBvpgf
            qhJqJlmcFnhJclllPgZjvpHpvfZpPbLn
            lpMJJhhcSMDMMwws
            jphtLMfVpjJRjJscMJptssnrwdNwQrNbwNzQTbcNrwQT
            gSPPSqGGGrdLrNQGrr
            PvWPDvWWCSSBBZPjLVDfhjsLLsDhtR
            hlLwDGLNnTrbNdtbdb
            ZfsvJbsJTrsttHTR
            vjPQJPFcmZjVFZFvbbVcJZJPBBhLMnDBznnGMDLMwBhlmBBl
            JdTJFtwHjJTzPMqPccqzjB
            rggffSCvNBCbWBWt
            ZsSpnnRpLStrZpTDwTVwGTJHDLdH
            sZqswsrcRpCrsCsrrbtpbpDlttlFbbpGtj
            LhNgNvNNhTQMhQMWhvvhfWhllbGGPbPtlPmFlDbjHHdlmg
            ffNBNMhDvQDhvzhBhNTBnSzzrZCZnrsVCSwcnrCC
            hHGhjLjwtFGwGhhhhtwjtlhrDBQrRBHczRcMvsBcRrDDMH
            TTfbZdZbPbVCmCdmnZmCVdfrJBczMrrznvBvQBzzzcBscn
            fdbPZTVVfSdmbfdvjjSGljhhtNGGhL
            fMrGQbPrbnfljjzVLQzNCzVv
            WcDqlSpctSJNzSFJLCzN
            hBBWcHtWgWDmZlwwrsPrRTRTMrmn
            ZJTVdgpzPpLVVwZgPzTPLwgWdhcWhSQCbcSbBtSWdSWchb
            qnDGnNjqDqNlqsCSWhMtlMltWSQB
            NnNrFQGjDRgLrgrpPr
            nCrhsmVrlrzsTvsnVvmTTlpvPJPWWMPJWWPCJMPNPgPJMjJj
            ctDqBLHLRLBSBqFRDBFqFFNGgjjrGGMrWftWJPGgwfGN
            HFcqZqqdcFQRQBdrlnplhspQlTmmvlph
            mllQMvMTMMdNNdTzTGmLgWjBgGtBqWHhGWjHtB
            PPsbbZPCVfJFJRJZsBHjjHhHcjqSSWBt
            wCVJFVRJDDpCPqZlTlwQnrvzmMdmml
            JfCJtCwfsffBJmFmgFmFhhdwgV
            lzHzsSHvSRlDRjlHTgqVVmmVPZqqmggmqS
            GzNNRTWvbWGvGQtfLnbfMbJfsC
            FnPrwqrFqsPrrsrwqwnbZFPwBQMhhdBHQZhTVBMdDHVhQQVh
            zlLWlLvLgtgbMdhfVDdzfd
            NWRNjLmWblGFsssNnSwPsw
            gnmCjzwnmCPTPhBwPjzBgqPjllJJSWlhfhQDSrpJRhDSlfJl
            rLHNHrLHVNbVHMMctZFHsbcsDSDWpSDSGfSRsRWSRllfGSSG
            NNtdMVrLNdZNvLvLZrzCndqBgwwPmwgjggBn
            tGSBRwwStBftfBHRScHwfcrCgQgDnjQhQDqgBqgCCDnnqg
            LNlbZmlPVNzWlLZVFPQqgDTQTmjqCQDQqmsQ
            bpZNZLNNZlLNLZNNZbLlbLZbwrwSHGJSwrGwRtRpcjjtMttw
            JvGNPWhLPLBffwhGCrbgnFDbgcZwbVnb
            TqzSTlQzdHQQpTTjSddHTSnbqnZDcrrFnFVFVbVVcbhc
            mlpdjhhTHWBmWWBJvG
            ScrppccsbMRRvltvrvrj
            HRTVTnDwDLJJJZwwVQTmNlvqBNtvWBBBQvhNfqlB
            TLJdLLCJZHJCVHHTwRdcsGpSbgsczcdcgS
            tffHzJctHsSHHHGTtzvttZFlZZhVjglVmgDhDdjgjS
            qCBMCqbpqfQPMBPpPljQVDDZdddZdgFlDV
            fWwLfbbWNzGGrzvWHJ
            VnNFqrrJdfQhCDFPhttD
            pGpTTzHmRTNTTLRRtbBBbzhPtbtbPPBt
            HLpHpmSRHTpllcLTSgVvNrJVfJvqMnZN
            tHzgwJCgzZlLFLnWJTnc
            NnNnmsMnBDFSFWdqssFd
            mDMBNmRRjjMNnvrPnjjRQQvfRgwpgHHpppHhZbzfCpbHtH
            TTwBnnZwBnNQZZWLWTTFNFbsCGrGFCNvDDDGFj
            lzPRfVVRMclPRMRcbFDjfCCGvvsdGCDd
            hSmmlMlVztlhRlVbqQpLnWqSqLZZwZQT
            zzVTcqmVqzdmhZJbFpQZQQtLLWLLbp
            TGwvGgTnGTRHLNtMftWHNbWf
            vljTGwvvlCljsgSnCBslDPPJrPdVzrSmhdqhVDPP
            LzCGCGLBGNlLmFFmmSSBBqSc
            ZJfbdfbWtbgVlblJtjcFcqTmFqqjtFHtjj
            QgZhZgQVdlfddlWPhfvMCGRGPDMMRvDNGvND
            nLdpLJSSnLMwjCDwnQhw
            NZGNgmsgPtPTgWqqCGwRbrDCQbCwhMjr
            gNqPTqTPttPZqcWfHLlBvccFvhpvJc
            GNdGhMMvRBjmMVjM
            trcZJJFmCgfZtcrQCfCZSpqSRjBQpQRQBbBqsSqR
            JcTmwtTtcrmThLGDhNTThvNW
            ZqhmtzzfZRsSfRmSTThMpLNgpgJQThMG
            jdnvdHWFvvjFdCWFrvVVnvFDQrJJMpgMJGNLJNJTPPgQGJGR
            vnHjDVHBWjdncDRbRzzzmmBsSSzt
            VZNZSCPTJPpvNTNsCrbnVrLccbLnnRVfWb
            MlqQBlBztFlhQJdFhccbhnRWWfnggfGc
            lzJqllwQtmzdHZpvwjPPNspj
            wTnCMnwQCQvTTJdfqhdtrrSmhttmmm
            LZlZglZBvjgbHHSrHpbr
            GWvPjPNGljBzMzJVMwNJMw
            CSlChlvPPGvdddqPqSJhPdbNbcMTMTbDbcRNDFcFLMLJ
            HWjgngmBZGQgRRNbFRcHbbzT
            BmnpnQBBssBsQBnPptSStllGhdCGrS
            nhQCnCvjchBBjMNrwbRwZvvSvSWW
            qgHlfqblVbPfVqlbGgPGfdfLSdNssWWLZsNsLZsdNdLSZZ
            gbGHzzbzHtPfcJhczmMnQBJn
            TTGJJPPZJGRzDwtQjTjzDC
            VbnrmNVWVWbffbVMsrbrnvFRjzCzQCjvQDDStDFS
            MhrRfMmfMmsHgsqPLLGdBqJJGHqd
            FMCMbmSQTHdCBmpFHprdHcDNqqfqJdJsDcclDDZlNf
            wzwRjwwtRhnzjRBWRnvtnWtnNsfsVDlDlsqVNNNqcqVlDvqf
            PtnGWjtwLBwtjCFPFpMpMbSrQm
            PWzrtrtzBBfjjWGbfNWvLJLgVSjRLVlSlllLpS
            HhZmHGGhGZRpQlpLpL
            dTdnHCnhmhcHcntrPPGfzfrcNtPz
            PfmWWWPwWdPdWPTVCdpjRnzhjDbrFnGbnQGQrrDR
            LSBnZLnJBQDLRGcQGc
            NHNqqBqvMMBsJgNvgsstBHNsdwwfTtwdpfTTmVmnWmtmWVlp
            zjzwTHCzDzbDzNTDjzDCCHRZmmSGmfgPmZGtHtgLmf
            hsqJMcQltLtPhLgL
            QWWWcMsWFJssrnsWrdlcPBwNTdzwTvvBvjwpTbBzpT
            LRvWZdLzzZWSqdpBzLdzLgRmbHPVHtFHMFFMCtHCfHcbVcqb
            sGGjNDnGTnlSSwsrTwcFVMHwCPPPcVfVHwPM
            GDQsDlJlQhSDTrpvhhWBLWvdRvWh
            sWhhdhdhbHSVBbFLZLnnCmCmtTTCCV
            RcQvjNrcrwGNcGNRJJmTpppgCCgppNgTtFmp
            GRRRGRGclfjwRsbfHFhWBDhdFs
            jfRTfgHqgDZHClcPcrGhnbcqrr
            FztdMLGBzpFJpcnzzclblcnbbl
            pdNBtdNLdvsNtdLpdGLTZDTgDjmvCZjCRCDDHg
            bdrbdZbJtZhrMrWRHHvRHRvHllqZ
            GGjCNgDVDFsCCwFNHjlrPrlSRWPcSlvl
            CNVDgDwVrQggDDQVsDwNwgTQdJtbfbLhtTdtLmnfbJMntnft
            mjznjLchnPPcLLnwCTFFvPgJJWdqJqJJdJJr
            bMlQRzbSBbRBMlMfMBBZFrqggvVvfqdDVDVDWWFd
            ZSSsRGQtSpBBpZMSbSpZsbtsjhCHTHcLCcjzjCwTTHhmNHtT
            ThCHLCfVfDTtDnDppTqclFfSclNrwNPwNfFr
            JmsQjJPJMWRRMddZGZWsdsMZrmcqvNSFSwrScrvwSwcccFFw
            ZWdJQGGzPJsMRZBGtHLgCHTTVTLBDtgn
            JVGJfttHgTLVTsnHgVHfwVBDjQDNQSjQwjbNbQjBbddS
            rPvZcZpcvtzcZddmNQjWQSjDpp
            rrRZPzRMztFFFqMZFtRVgnsLnVHfVHqJnghHJL
            grrZZbJSggQDLgrvSSDBVsGdjHjnGnBGVsLGHj
            pCtWtPtffPRcWdBsGsGRBRvhBj
            zmvNNclfZJJFZQbN
            DDqCgPPDgtDSPPDbgCqcmBMBTQLQZBWwQZbsMWZZMw
            RNlNvpvNvndNjMZtBpwMTWLBZt
            VlNJvRzdlGFRFGRRRjFVJRRggtPPHgHzgStqCcHHmHqcrc
            RfmdFgbtFLHlsjRPsL
            LqrhvCTvNNhWBvBTrThrDWZrPjMQPQMcjzsPcQHTlVHQjcMM
            BhhrJWJLvCbfJbwgtgJn
            FWpRfFRjtjFpVvbTTZFPhJhJLdCLdWBhPmHmCW
            McMzNlGrgGGsHcqmdLqbhJmd
            lNMwsnMzzsSSGtVVSfvZTtSppb
            JrJQDJDVvGwGVwvcGCRRcCBBqsWBRZqWZZ
            bNdmhvMpjmHbNbpNvmbBqlRWlCtCqlRZqRtW
            HmTjNdmMfTTVvLSzvz
            WMQWmfGfQfVnMGWGmGtGWHzZtdLzpZhwrtZcwZzdps
            jBgljNPbNjPFRbggNlNBCcHsrLLLHlrLslhlzdhdHppp
            BBPBJbFCTGJcVQMGMv
            fdmfmmjbPmjlmfhfGglTNLCNvPNSpPvpvSLCPCpS
            MtJwMrwrZJVHMgqJHtwVJzVVLCvpNLvDrLvQSQSNcCNpFNLS
            wWMVWZzqqMRHztwJZzRqVtjGlBdhbGGbThhTlnTBTWgb
            ShhrjPrvhlljnHrggPvvSqRMBZZqBTZmMmTmTMdD
            ctLzbcpWCJbNWRQqBBdZFMBdfZdJBm
            GQWpzLcVpVNpRggHrhhgvnGPwj
            PdzSrmmqSgWWddNQds
            TZbwCTLZbHLWptQHhpgNsc
            MZjBLjMLDTDqrrGflsjjrf
            DBHTnlGGBPjPmwRWhn
            hgLgZccSrcMgLMSpCLJjNWmPWjmVWdwJjd
            MfQMScQrMSprrTGHBhqTvqlGQT
            CDvLRCCzQDWzcGQGvRcpVFVsgTsFrgllrTpF
            mjbqtHqHbspspnMv
            ZvvqdqqHvLhDhJWzJd
            ThHnbRTVbQHSWvBVVBCPBW
            FFJgfqfqNwNrvDCBNppP
            jzsFfqwqssLzJjffJcssHQHQdnMdhTGHLbddbCnn
            gwMHHhbSwnqHrgMqMbnBcldhzBLQBQhBLtLttQ
            dCRmpfvpCzcQllflQz
            TjPsCJmvZPNPsvZpPTTRCpprjdbrHngqDwqMrDnMbMbHgM
            CgNQpgTCgNltHTNQlHpRnRnzBfJnPnmpcpfq
            LGrrvGSMGvrsWPBmnJPmPfmrqr
            VGsSvdJvbSHVtlttNVHT
            LnZDtzpzNpPsCbfBbDCDBC
            gSGRSSghqhhSvSRvvhvVqFJdsfBsCHJbVfddCJ
            vglRRjQSmnQQCNrL
            HwhVddVVwRcGHGjlfS
            MbBvDBGvWqpNWvMbzDMNZZlLcjlSclflcjqgfCRg
            bvDWDWQbspPPWWQMnGdnFnJtJFGJhhPJ
            nDJDdQdPDlDJnnbRQDlTqVfFwfVtjJjjFfqqFqgN
            hScrSmSCTZvZCSmZLFwfffqgjfhNGwjhfw
            zCzsCCTcMBmSLmsMWHdPWRQPQPddDQ
            lzGflPZLSqSlccpqjpdNCwjdsjCnCsJp
            VghPQDVMFQNdJjRNBw
            tVrhDVmHTlPlGrzL
            gfSJJlzvGgRPpggR
            VLDDHhHtlZnnZqbGmtqPmmmmWN
            VVDBnddDBFFzlscC
            cmmzRzcRjFrGncTHqc
            ghJfwJJvqhbrdndWgddWBH
            fQbSpJwSthbhtvpCwqQbsDPMNLlpRmplzPlRMPzM
            bBVQDgBpTzbhpgQVhTmBVBzgrvcnrncsnZrwzHJZfnHcZfrP
            tdWlFLMHGFGRGMRLNFHlfwJcrPwcsnfwcvZPfr
            RLWGjHLjSjtjmBQVgpQhhg
            ttRRJBrCfpprmFqSJVTSwNJNTWlVTn
            nLsMghDbQdnhwWNLjcwNSlVH
            ZZDgnDQvDdndPCmfrRqzvFqpmp
            PPzCrcGGlnhPcsdfNZZdpLLNZsfd
            RjjWHjVWDvjWqVMHjHJjVlHdwwJbLfNZdfdgfpppgpfpZw
            lBVvqjQqBDBlVmCFGChhnSmTTrmr
            BZnGZFvGvBGGrwLBZlzNgmzMhMdfmwgmdmmt
            cpDHtVjDWjCtDTCcDNhhzNJszgzMTJhmgg
            VWWcRWDpPDPPtHtScqFrLlBFFFSFBqZLSF
            qBFcCGFcHHGBldzBLtdzSrdR
            fpmfpswfQNQmfPHfPPgJNwRtngTtSTRzdTrLRnSnldLd
            fsHNpNPwQZwhVHMFGqvvMcqWFGVF
            FwFJlqDDwwgFHQdmFmSQ
            pPtzcrLHZrQfdsBsdLdf
            bHrrHjbrjbrJvDvbqMVNqJ
            WVVpPHPfWnHmpccpnpvQcrgNNMSCTMjMgjjMMN
            RsZbhRFTDDJtZFJhTLRRLMrMrCdSNCdSMjrNhjNGSQ
            LLqtqqzwqmmflPTq
            mmLhdZSdqhqnqMZShLQrMWcrcWQwTgrWVVWc
            CCvjjsfJRCCJbDbFsbGJvzgWWGlWrWlwTQrwQGGcHlBg
            NRDbRCNsNjQPSSLZNdLn
            cmVLcQZPSHBGlSddBf
            DFNzDNszlbBlgHNN
            tWRzFjsWWtrtlDztzwjDjThLPhRMpppLMhmMhnmncRcn
            LFFcgdNLpLQggZQMFMcNJggRHCHsTtRtHTzCTZHRsfSRfs
            qnhlhmGrrhhnqdmGhdhWbnSRzSfsBRSTSRtBflRffzfz
            PnbmrmGjWMVNvdPFLp
            swcWsMMmVwWwFtWlbnnZnFBhbNfrhN
            dQLZHjpDQCfBBBBTGTTC
            DJvDpDSzSDQZMWsWwPqVtwcS
            NVTMjjGGNBqhNttdTTjtcqjCfDlhZhSWCFFJmSmZmWJhmZ
            rznsHPnRLzwspZDWfGZJSLZZDC
            QzPRRvRQszQsGQcVNqTBBdVj
            rHGBglBNLpbqCgFC
            PbmbRnmMSbRPDWRnDVSMPMWmvvcvqqppTLZZFpvCpczLcCVv
            dsdMSPtMdPnSffQwGGsBBbQw
            nqjTlGPGnqWsMPPwGdGjQvQvJCCQBvmvCvQJtmCw
            DDhVbDrcVVFZLzHrZBRNCWStmQWztJvtCm
            VHDLhFFDpcHZcHGWfsGlspTTMqps
            FTPZwBzHHFLTTSwHLJTwVQqnDrzgRRVgQpDVRprn
            jJMjsWlvQqVrqgWW
            CjNsjjvlmslbcJmmbtCtCThdwhHLhhhLPdBCSPFh
            jfgllWfLrfmlTjsCjcjDNNDnNcHJnd
            MMBRSRZGppGFpBbbBGvVnFHhcCJqNcNcHCFNgnnn
            pMZZgBRVZVGRtRSMbMbvRQmTswWfzLzLzWLrPQmfwLlW
            tzpdHLNpfpPnlNFHnpssbgShtqcgTTggrsqg
            JZwWGCWMCcbsSHgWjq
            QCmDZCJwmvZvCVCVRQGCDMFBNlfHmfLLzPPfdpfBLlPB
            PCvRTdPPBVBTGgLGrGqMrMnv
            twQwStrsQwstjSHmmpqZpwqNGnGnNnZgLN
            mJScfjbttQjQtjcmfbbQJHFTBfdfRhhrPhhTfPVVhPPB
            DMPJmLLjhJwNBCNBww
            TpccnsZsbTHpsTHVszbpbGHSNwBtWlfrtCtCfrtlBlFZlf
            HsHvccvzbqsGzqnnHvLQPghQNNDDvLLjdjLR
            zmgVMrrjjMGbbzzdqqrgVbRTHqTTThpNHphNTvvvTNnv
            QLSmZmSJTvTnZTvn
            SfDtDDmQCFDwWmSrjPPGfjMjjGfMgV
            hdNHNHjnGHMTcpWlhBchRBJR
            fPztCTPtttLwLzVbwqSVtCBBDpWvlcRRlBpbDBQWcDWJ
            ftrCVzfTCFFzTFPrPjNZFHnNsMdZgjHdss
            TVcTbdqLqzHHRNHM
            PppQTWffPfCPQSsCprzRwRJDzMDzNwRBRPHN
            pjCTZjTjmTtsZhGcGdLvdlgv
            VJRhVfJRBgbdrrrvJpJJ
            cCSSHSHnZPwDFNHCDCQdbQQdvqnMsrpqQnvq
            NFFCwSrDzCNrwhtgzhWtBhgzWB
            RRBRczzcvmfzVRzVPvPTlCWnnlTGqGMgTTnG
            tNLdSdNSMFhsFttddtjlwGqllqQglqTWqwnThT
            rLSsLrNdZbbHjLdSFFMjLLtSfVRJzVJJVZcRfvZVRfDpVvRz
            DBsdssbdbDfPnnqzzJbqStqzjjJS
            RcGMGwwmrJjFFHPG
            mCgwMLPgCPmmwWDBDZvWvBCWfZ
            cJCGJJMZcMGWMhWCJTfFSfDmmgFmtshggffr
            vBVQBDbNstQmFsfm
            RVwHNblzwHvNdvBwNjVHGZJZLJTMLMJDZLGRMDGG
            LNCssCldDbrnNtVWNQ
            mmcpRBMBRBTZzgMMhtFFvrWQrQmWFtvn
            MZTgzMZSzTfSMDHwCfPlLLDnwL
            HlPcjMSHsMSPbgLhFPFNzP
            ZfRhtVdGBNLFzLqf
            DRtGGtRGJJTJDZDGdCJrVJmlWvHWcvjMsMWmhQsmCMjW
            swpQcsBvvHFpBHHcCHJvJddvbbWPdzhzzqqWdhPnhP
            gDDGTgjNWZTMTNjjggRLggldSPqSqGznnhnbdfnbqfhh
            WDMDtDNDctVFJstJ
            rFDbGjrGbpBBbrCbrwpvvZQZZhgTLVVVVLgThCTggg
            NlfHpttqzltMzRSMSdWRNSfSTTmqgcLgQVcQTcmgQgmZVPVZ
            HWSWpMHNpNWlpNMsMzWGGwwBvvwBnwBvsnnvnB
            mZVVHmmRZlvdjvNpHh
            DFBnFDtnFbBMrQbBMvFLvgtjjNpcLpJdNzJJdhWNpJNWcN
            QTsbrQggBsvsgVTwRVGZCfGZfR
            RGNGlGTWJnJlMcRMGqvSmnDtvDDvtLSLvr
            HfsFhPPdVshfbggDVmzcvSwvStVzDq
            BPPfCgCFfcBbPbHbBHZPFsbBpMGlClRNJRlQTjQWjWpTTlGT
            HQNqQbbRQHbZPZQPqbZTvWFWmCjvFRvRTSrRrr
            lBpBpzLLdBwsLwLLWNggzCFTCmFgWmrF
            VwsswGVBfJfccLBcsJGNdpJHZZqnhtqqnhPHDZHVtPQMZn
            LMHnHnPMnFdJFNFJjZvrJF
            wlTlslptlwtzcvTqvTsVSWWrbJfmJZNZJjcNWfNJmf
            qDlqVthTztSSpSlqtpTTzLvRRnnCvRCPLBQGDBdDGD
            HlmlJgRBBpJLpPBHnlLJsrgJDMttvSdddcMSStWjjWtcSzjs
            qfTbNPTVGhGFCVGTwZfNZNNVWvjSczcjStMMcdSczzczvbcW
            GZVqffQTwNQTmPRlggHLprHQ
            BjsWschcTjjWclQTSnZFrjtFtbzZfqntzF
            qggNGMHgvHMRZMtznbrftMCn
            qvHdqpwgJTsVccwscT
            FJwNPHJmPHTJHglTFwgmwqtShBqDmDBzzBzWhCDWqQ
            fpsjNsMVLVjDCCSzBtjztt
            sLrdfbsMcbMRZZZbbsfrsrNgGNglRwllRnJnwFvnFHnG
            lWWVTJlJCTTzDdWzqdtFFt
            PvPvrhbjhgSjvJQSnQRbjZDZFFHMtGGqFtRMGZFtGH
            rhPrSgfvJPfmwsTpLcsV
            """;

    public static void main(String[] args) {
        int sum = part1();
        System.out.println(sum);
        sum = part2();
        System.out.println(sum);
    }

    private static int part1() {
        return INPUT.lines().mapToInt(rucksack -> {
            String compartiment1 = rucksack.substring(0, rucksack.length() / 2);
            String compartiment2 = rucksack.substring(rucksack.length() / 2);

            char error = intersect(compartiment1, compartiment2);
            return getPriority(error);
        }).sum();
    }

    private static int part2() {
        StringBuilder tmp = new StringBuilder();
        List<String> setOfThreeLines = extractSetOfThreeLines(tmp);
        return setOfThreeLines.stream().mapToInt(rucksack -> {
            List<String> linesOfSet = rucksack.lines().toList();

            char error = intersect(linesOfSet.get(0), linesOfSet.get(1), linesOfSet.get(2));
            return getPriority(error);
        }).sum();
    }

    private static List<String> extractSetOfThreeLines(StringBuilder tmp) {
        List<String> setOfThreeLines = new ArrayList<>();
        List<String> lines = INPUT.lines().toList();
        for(int i = 0; i<lines.size(); i++) {
            if(i % 3 == 0 && i > 0){
                setOfThreeLines.add(tmp.toString());
                tmp = new StringBuilder();
            }
            tmp.append(lines.get(i)).append("\n");

        }
        setOfThreeLines.add(tmp.substring(0, tmp.length() - 1));
        return setOfThreeLines;
    }

    private static char intersect(String compartiment1, String compartiment2) {
        return (char)compartiment1.chars()
                .filter(c -> compartiment2.contains(String.valueOf((char)c)))
                .findFirst()
                .orElse(-1);
    }

    private static char intersect(String compartiment1, String compartiment2, String compartiment3) {
        return (char)compartiment1.chars()
                .filter(c -> compartiment2.contains(String.valueOf((char)c)))
                .filter(c -> compartiment3.contains(String.valueOf((char)c)))
                .findFirst()
                .orElse(-1);
    }

    private static int getPriority(char character){
        return Character.isLowerCase(character) ?
                (character) - 96 : (character) - 38;
    }

}
