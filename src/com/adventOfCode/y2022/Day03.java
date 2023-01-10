package com.adventOfCode.y2022;

import java.util.ArrayList;
import java.util.List;

/**
 * --- Day 3: Rucksack Reorganization ---
 * One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.
 *
 * Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
 *
 * The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).
 *
 * The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same number of items in each of its two compartments, so the first half of the characters represent items in the first compartment, while the second half of the characters represent items in the second compartment.
 *
 * For example, suppose you have the following list of contents from six rucksacks:
 *
 * vJrwpWtwJgWrhcsFMMfFFhFp
 * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
 * PmmdzqPrVvPwwTWBwg
 * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
 * ttgJtRGJQctTZtZT
 * CrZsJsPPZsGzwwsLwLmpwMDw
 * The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
 * The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
 * The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
 * The fourth rucksack's compartments only share item type v.
 * The fifth rucksack's compartments only share item type t.
 * The sixth rucksack's compartments only share item type s.
 * To help prioritize item rearrangement, every item type can be converted to a priority:
 *
 * Lowercase item types a through z have priorities 1 through 26.
 * Uppercase item types A through Z have priorities 27 through 52.
 * In the above example, the priority of the item type that appears in both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
 *
 * Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?
 *
 * Your puzzle answer was 7903.
 *
 * --- Part Two ---
 * As you finish identifying the misplaced items, the Elves come to you with another issue.
 *
 * For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.
 *
 * The problem is that someone forgot to put this year's updated authenticity sticker on the badges. All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.
 *
 * Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.
 *
 * Every set of three lines in your list corresponds to a single group, but each group can have a different badge item type. So, in the above example, the first group's rucksacks are the first three lines:
 *
 * vJrwpWtwJgWrhcsFMMfFFhFp
 * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
 * PmmdzqPrVvPwwTWBwg
 * And the second group's rucksacks are the next three lines:
 *
 * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
 * ttgJtRGJQctTZtZT
 * CrZsJsPPZsGzwwsLwLmpwMDw
 * In the first group, the only item type that appears in all three rucksacks is lowercase r; this must be their badges. In the second group, their badge item type must be Z.
 *
 * Priorities for these items must still be found to organize the sticker attachment efforts: here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.
 *
 * Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?
 *
 * Your puzzle answer was 2548.
 */
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
