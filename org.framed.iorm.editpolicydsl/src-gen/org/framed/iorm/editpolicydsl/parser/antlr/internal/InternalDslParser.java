package org.framed.iorm.editpolicydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.framed.iorm.editpolicydsl.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'override'", "'('", "')'", "'when'", "';'", "'ContainsCompartment'", "'IsTargetType'", "'IsParent'", "'IsSourceType'", "'IsTarget'", "'InCompartment'", "'SourceEqualsTarget'", "'SourceEqualsTargetType'", "'true'", "'false'", "'or'", "'and'", "'!'", "'=>'", "'Add'", "'Reconnect'", "'Create'", "'Start'", "'Execute'", "'Direct_Edit'", "'Add_Property'", "'Create_Attribute'", "'Create_Operation'", "'Create_Property'", "'Acyclic'", "'CompartmentType'", "'Cyclic'", "'DataType'", "'Fulfillment'", "'Inheritance'", "'Group'", "'Reflexive'", "'Relationship'", "'RelationshipExclusion'", "'RelationshipImplication'", "'RoleType'", "'RoleEquivalence'", "'RoleGroup'", "'RoleImplication'", "'RoleProhibition'", "'Irreflexive'", "'NaturalType'", "'Compartment_Behavior'", "'Compartment_Inheritance'", "'Compartment_Properties'", "'Compartment_Structure'", "'Compartment_Types'", "'Contains_Compartments'", "'Compartments'", "'Data_Type_Inheritance'", "'Data_Types'", "'Dates'", "'Dependent'", "'Group_Constraints'", "'Inter_Relationship_Constraints'", "'Intra_Relationship_Constraints'", "'Naturals'", "'Occurrence_Constraints'", "'On_Compartments'", "'On_Relationships'", "'Parthood_Constraints'", "'Participants'", "'Playable'", "'Playable_by_Defining_Compartment'", "'Players'", "'Relationship_Cardinality'", "'Relationship_Constraints'", "'Relationships'", "'RML_Feature_Model'", "'Role_Behavior'", "'Role_Constraints'", "'Role_Equivalence'", "'Role_Implication'", "'Role_Inheritance'", "'Role_Prohibition'", "'Role_Properties'", "'Role_Structure'", "'Role_Types'", "'Roles'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDsl.g"; }



     	private DslGrammarAccess grammarAccess;

        public InternalDslParser(TokenStream input, DslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected DslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalDsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalDsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalDsl.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalDsl.g:72:1: ruleModel returns [EObject current=null] : ( ( (lv_policies_0_0= rulePolicy ) ) ( (lv_policies_1_0= rulePolicy ) )* )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_policies_0_0 = null;

        EObject lv_policies_1_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:78:2: ( ( ( (lv_policies_0_0= rulePolicy ) ) ( (lv_policies_1_0= rulePolicy ) )* )? )
            // InternalDsl.g:79:2: ( ( (lv_policies_0_0= rulePolicy ) ) ( (lv_policies_1_0= rulePolicy ) )* )?
            {
            // InternalDsl.g:79:2: ( ( (lv_policies_0_0= rulePolicy ) ) ( (lv_policies_1_0= rulePolicy ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11||(LA2_0>=30 && LA2_0<=39)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDsl.g:80:3: ( (lv_policies_0_0= rulePolicy ) ) ( (lv_policies_1_0= rulePolicy ) )*
                    {
                    // InternalDsl.g:80:3: ( (lv_policies_0_0= rulePolicy ) )
                    // InternalDsl.g:81:4: (lv_policies_0_0= rulePolicy )
                    {
                    // InternalDsl.g:81:4: (lv_policies_0_0= rulePolicy )
                    // InternalDsl.g:82:5: lv_policies_0_0= rulePolicy
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getPoliciesPolicyParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_policies_0_0=rulePolicy();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					add(
                    						current,
                    						"policies",
                    						lv_policies_0_0,
                    						"org.framed.iorm.editpolicydsl.Dsl.Policy");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }

                    // InternalDsl.g:99:3: ( (lv_policies_1_0= rulePolicy ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==11||(LA1_0>=30 && LA1_0<=39)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalDsl.g:100:4: (lv_policies_1_0= rulePolicy )
                    	    {
                    	    // InternalDsl.g:100:4: (lv_policies_1_0= rulePolicy )
                    	    // InternalDsl.g:101:5: lv_policies_1_0= rulePolicy
                    	    {

                    	    					newCompositeNode(grammarAccess.getModelAccess().getPoliciesPolicyParserRuleCall_1_0());
                    	    				
                    	    pushFollow(FOLLOW_3);
                    	    lv_policies_1_0=rulePolicy();

                    	    state._fsp--;


                    	    					if (current==null) {
                    	    						current = createModelElementForParent(grammarAccess.getModelRule());
                    	    					}
                    	    					add(
                    	    						current,
                    	    						"policies",
                    	    						lv_policies_1_0,
                    	    						"org.framed.iorm.editpolicydsl.Dsl.Policy");
                    	    					afterParserOrEnumRuleCall();
                    	    				

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePolicy"
    // InternalDsl.g:122:1: entryRulePolicy returns [EObject current=null] : iv_rulePolicy= rulePolicy EOF ;
    public final EObject entryRulePolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicy = null;


        try {
            // InternalDsl.g:122:47: (iv_rulePolicy= rulePolicy EOF )
            // InternalDsl.g:123:2: iv_rulePolicy= rulePolicy EOF
            {
             newCompositeNode(grammarAccess.getPolicyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePolicy=rulePolicy();

            state._fsp--;

             current =iv_rulePolicy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePolicy"


    // $ANTLR start "rulePolicy"
    // InternalDsl.g:129:1: rulePolicy returns [EObject current=null] : ( ( (lv_override_0_0= 'override' ) )? ( (lv_action_1_0= ruleActionEnum ) ) ( (lv_actionType_2_0= ruleFeatureTypeEnum ) ) otherlv_3= '(' ( (lv_featureRule_4_0= ruleFeatureExpression ) ) otherlv_5= ')' otherlv_6= 'when' ( (lv_constraintRule_7_0= ruleConstraintExpression ) ) otherlv_8= ';' ) ;
    public final EObject rulePolicy() throws RecognitionException {
        EObject current = null;

        Token lv_override_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_action_1_0 = null;

        Enumerator lv_actionType_2_0 = null;

        EObject lv_featureRule_4_0 = null;

        EObject lv_constraintRule_7_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:135:2: ( ( ( (lv_override_0_0= 'override' ) )? ( (lv_action_1_0= ruleActionEnum ) ) ( (lv_actionType_2_0= ruleFeatureTypeEnum ) ) otherlv_3= '(' ( (lv_featureRule_4_0= ruleFeatureExpression ) ) otherlv_5= ')' otherlv_6= 'when' ( (lv_constraintRule_7_0= ruleConstraintExpression ) ) otherlv_8= ';' ) )
            // InternalDsl.g:136:2: ( ( (lv_override_0_0= 'override' ) )? ( (lv_action_1_0= ruleActionEnum ) ) ( (lv_actionType_2_0= ruleFeatureTypeEnum ) ) otherlv_3= '(' ( (lv_featureRule_4_0= ruleFeatureExpression ) ) otherlv_5= ')' otherlv_6= 'when' ( (lv_constraintRule_7_0= ruleConstraintExpression ) ) otherlv_8= ';' )
            {
            // InternalDsl.g:136:2: ( ( (lv_override_0_0= 'override' ) )? ( (lv_action_1_0= ruleActionEnum ) ) ( (lv_actionType_2_0= ruleFeatureTypeEnum ) ) otherlv_3= '(' ( (lv_featureRule_4_0= ruleFeatureExpression ) ) otherlv_5= ')' otherlv_6= 'when' ( (lv_constraintRule_7_0= ruleConstraintExpression ) ) otherlv_8= ';' )
            // InternalDsl.g:137:3: ( (lv_override_0_0= 'override' ) )? ( (lv_action_1_0= ruleActionEnum ) ) ( (lv_actionType_2_0= ruleFeatureTypeEnum ) ) otherlv_3= '(' ( (lv_featureRule_4_0= ruleFeatureExpression ) ) otherlv_5= ')' otherlv_6= 'when' ( (lv_constraintRule_7_0= ruleConstraintExpression ) ) otherlv_8= ';'
            {
            // InternalDsl.g:137:3: ( (lv_override_0_0= 'override' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDsl.g:138:4: (lv_override_0_0= 'override' )
                    {
                    // InternalDsl.g:138:4: (lv_override_0_0= 'override' )
                    // InternalDsl.g:139:5: lv_override_0_0= 'override'
                    {
                    lv_override_0_0=(Token)match(input,11,FOLLOW_4); 

                    					newLeafNode(lv_override_0_0, grammarAccess.getPolicyAccess().getOverrideOverrideKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPolicyRule());
                    					}
                    					setWithLastConsumed(current, "override", true, "override");
                    				

                    }


                    }
                    break;

            }

            // InternalDsl.g:151:3: ( (lv_action_1_0= ruleActionEnum ) )
            // InternalDsl.g:152:4: (lv_action_1_0= ruleActionEnum )
            {
            // InternalDsl.g:152:4: (lv_action_1_0= ruleActionEnum )
            // InternalDsl.g:153:5: lv_action_1_0= ruleActionEnum
            {

            					newCompositeNode(grammarAccess.getPolicyAccess().getActionActionEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_action_1_0=ruleActionEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPolicyRule());
            					}
            					set(
            						current,
            						"action",
            						lv_action_1_0,
            						"org.framed.iorm.editpolicydsl.Dsl.ActionEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDsl.g:170:3: ( (lv_actionType_2_0= ruleFeatureTypeEnum ) )
            // InternalDsl.g:171:4: (lv_actionType_2_0= ruleFeatureTypeEnum )
            {
            // InternalDsl.g:171:4: (lv_actionType_2_0= ruleFeatureTypeEnum )
            // InternalDsl.g:172:5: lv_actionType_2_0= ruleFeatureTypeEnum
            {

            					newCompositeNode(grammarAccess.getPolicyAccess().getActionTypeFeatureTypeEnumEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_actionType_2_0=ruleFeatureTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPolicyRule());
            					}
            					set(
            						current,
            						"actionType",
            						lv_actionType_2_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getPolicyAccess().getLeftParenthesisKeyword_3());
            		
            // InternalDsl.g:193:3: ( (lv_featureRule_4_0= ruleFeatureExpression ) )
            // InternalDsl.g:194:4: (lv_featureRule_4_0= ruleFeatureExpression )
            {
            // InternalDsl.g:194:4: (lv_featureRule_4_0= ruleFeatureExpression )
            // InternalDsl.g:195:5: lv_featureRule_4_0= ruleFeatureExpression
            {

            					newCompositeNode(grammarAccess.getPolicyAccess().getFeatureRuleFeatureExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_8);
            lv_featureRule_4_0=ruleFeatureExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPolicyRule());
            					}
            					set(
            						current,
            						"featureRule",
            						lv_featureRule_4_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getPolicyAccess().getRightParenthesisKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getPolicyAccess().getWhenKeyword_6());
            		
            // InternalDsl.g:220:3: ( (lv_constraintRule_7_0= ruleConstraintExpression ) )
            // InternalDsl.g:221:4: (lv_constraintRule_7_0= ruleConstraintExpression )
            {
            // InternalDsl.g:221:4: (lv_constraintRule_7_0= ruleConstraintExpression )
            // InternalDsl.g:222:5: lv_constraintRule_7_0= ruleConstraintExpression
            {

            					newCompositeNode(grammarAccess.getPolicyAccess().getConstraintRuleConstraintExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_11);
            lv_constraintRule_7_0=ruleConstraintExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPolicyRule());
            					}
            					set(
            						current,
            						"constraintRule",
            						lv_constraintRule_7_0,
            						"org.framed.iorm.editpolicydsl.Dsl.ConstraintExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getPolicyAccess().getSemicolonKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePolicy"


    // $ANTLR start "entryRuleConstraintRule"
    // InternalDsl.g:247:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalDsl.g:247:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalDsl.g:248:2: iv_ruleConstraintRule= ruleConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintRule=ruleConstraintRule();

            state._fsp--;

             current =iv_ruleConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintRule"


    // $ANTLR start "ruleConstraintRule"
    // InternalDsl.g:254:1: ruleConstraintRule returns [EObject current=null] : (this_TrueConstraintRule_0= ruleTrueConstraintRule | this_FalseConstraintRule_1= ruleFalseConstraintRule | this_ContainsCompartmentConstrainRule_2= ruleContainsCompartmentConstrainRule | this_IsTargetConstraintRule_3= ruleIsTargetConstraintRule | this_IsTargetTypeConstraintRule_4= ruleIsTargetTypeConstraintRule | this_IsSourceTypeConstraintRule_5= ruleIsSourceTypeConstraintRule | this_IsParentConstraintRule_6= ruleIsParentConstraintRule | this_SourceEqualsTargetConstraintRule_7= ruleSourceEqualsTargetConstraintRule | this_SourceEqualsTargetTypeConstraintRule_8= ruleSourceEqualsTargetTypeConstraintRule | this_InCompartmentConstraintRule_9= ruleInCompartmentConstraintRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject this_TrueConstraintRule_0 = null;

        EObject this_FalseConstraintRule_1 = null;

        EObject this_ContainsCompartmentConstrainRule_2 = null;

        EObject this_IsTargetConstraintRule_3 = null;

        EObject this_IsTargetTypeConstraintRule_4 = null;

        EObject this_IsSourceTypeConstraintRule_5 = null;

        EObject this_IsParentConstraintRule_6 = null;

        EObject this_SourceEqualsTargetConstraintRule_7 = null;

        EObject this_SourceEqualsTargetTypeConstraintRule_8 = null;

        EObject this_InCompartmentConstraintRule_9 = null;



        	enterRule();

        try {
            // InternalDsl.g:260:2: ( (this_TrueConstraintRule_0= ruleTrueConstraintRule | this_FalseConstraintRule_1= ruleFalseConstraintRule | this_ContainsCompartmentConstrainRule_2= ruleContainsCompartmentConstrainRule | this_IsTargetConstraintRule_3= ruleIsTargetConstraintRule | this_IsTargetTypeConstraintRule_4= ruleIsTargetTypeConstraintRule | this_IsSourceTypeConstraintRule_5= ruleIsSourceTypeConstraintRule | this_IsParentConstraintRule_6= ruleIsParentConstraintRule | this_SourceEqualsTargetConstraintRule_7= ruleSourceEqualsTargetConstraintRule | this_SourceEqualsTargetTypeConstraintRule_8= ruleSourceEqualsTargetTypeConstraintRule | this_InCompartmentConstraintRule_9= ruleInCompartmentConstraintRule ) )
            // InternalDsl.g:261:2: (this_TrueConstraintRule_0= ruleTrueConstraintRule | this_FalseConstraintRule_1= ruleFalseConstraintRule | this_ContainsCompartmentConstrainRule_2= ruleContainsCompartmentConstrainRule | this_IsTargetConstraintRule_3= ruleIsTargetConstraintRule | this_IsTargetTypeConstraintRule_4= ruleIsTargetTypeConstraintRule | this_IsSourceTypeConstraintRule_5= ruleIsSourceTypeConstraintRule | this_IsParentConstraintRule_6= ruleIsParentConstraintRule | this_SourceEqualsTargetConstraintRule_7= ruleSourceEqualsTargetConstraintRule | this_SourceEqualsTargetTypeConstraintRule_8= ruleSourceEqualsTargetTypeConstraintRule | this_InCompartmentConstraintRule_9= ruleInCompartmentConstraintRule )
            {
            // InternalDsl.g:261:2: (this_TrueConstraintRule_0= ruleTrueConstraintRule | this_FalseConstraintRule_1= ruleFalseConstraintRule | this_ContainsCompartmentConstrainRule_2= ruleContainsCompartmentConstrainRule | this_IsTargetConstraintRule_3= ruleIsTargetConstraintRule | this_IsTargetTypeConstraintRule_4= ruleIsTargetTypeConstraintRule | this_IsSourceTypeConstraintRule_5= ruleIsSourceTypeConstraintRule | this_IsParentConstraintRule_6= ruleIsParentConstraintRule | this_SourceEqualsTargetConstraintRule_7= ruleSourceEqualsTargetConstraintRule | this_SourceEqualsTargetTypeConstraintRule_8= ruleSourceEqualsTargetTypeConstraintRule | this_InCompartmentConstraintRule_9= ruleInCompartmentConstraintRule )
            int alt4=10;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt4=1;
                }
                break;
            case 25:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                alt4=3;
                }
                break;
            case 20:
                {
                alt4=4;
                }
                break;
            case 17:
                {
                alt4=5;
                }
                break;
            case 19:
                {
                alt4=6;
                }
                break;
            case 18:
                {
                alt4=7;
                }
                break;
            case 22:
                {
                alt4=8;
                }
                break;
            case 23:
                {
                alt4=9;
                }
                break;
            case 21:
                {
                alt4=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDsl.g:262:3: this_TrueConstraintRule_0= ruleTrueConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getTrueConstraintRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrueConstraintRule_0=ruleTrueConstraintRule();

                    state._fsp--;


                    			current = this_TrueConstraintRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDsl.g:271:3: this_FalseConstraintRule_1= ruleFalseConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getFalseConstraintRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FalseConstraintRule_1=ruleFalseConstraintRule();

                    state._fsp--;


                    			current = this_FalseConstraintRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDsl.g:280:3: this_ContainsCompartmentConstrainRule_2= ruleContainsCompartmentConstrainRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getContainsCompartmentConstrainRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContainsCompartmentConstrainRule_2=ruleContainsCompartmentConstrainRule();

                    state._fsp--;


                    			current = this_ContainsCompartmentConstrainRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDsl.g:289:3: this_IsTargetConstraintRule_3= ruleIsTargetConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getIsTargetConstraintRuleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsTargetConstraintRule_3=ruleIsTargetConstraintRule();

                    state._fsp--;


                    			current = this_IsTargetConstraintRule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalDsl.g:298:3: this_IsTargetTypeConstraintRule_4= ruleIsTargetTypeConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getIsTargetTypeConstraintRuleParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsTargetTypeConstraintRule_4=ruleIsTargetTypeConstraintRule();

                    state._fsp--;


                    			current = this_IsTargetTypeConstraintRule_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDsl.g:307:3: this_IsSourceTypeConstraintRule_5= ruleIsSourceTypeConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getIsSourceTypeConstraintRuleParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsSourceTypeConstraintRule_5=ruleIsSourceTypeConstraintRule();

                    state._fsp--;


                    			current = this_IsSourceTypeConstraintRule_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalDsl.g:316:3: this_IsParentConstraintRule_6= ruleIsParentConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getIsParentConstraintRuleParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsParentConstraintRule_6=ruleIsParentConstraintRule();

                    state._fsp--;


                    			current = this_IsParentConstraintRule_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalDsl.g:325:3: this_SourceEqualsTargetConstraintRule_7= ruleSourceEqualsTargetConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getSourceEqualsTargetConstraintRuleParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_SourceEqualsTargetConstraintRule_7=ruleSourceEqualsTargetConstraintRule();

                    state._fsp--;


                    			current = this_SourceEqualsTargetConstraintRule_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalDsl.g:334:3: this_SourceEqualsTargetTypeConstraintRule_8= ruleSourceEqualsTargetTypeConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getSourceEqualsTargetTypeConstraintRuleParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_SourceEqualsTargetTypeConstraintRule_8=ruleSourceEqualsTargetTypeConstraintRule();

                    state._fsp--;


                    			current = this_SourceEqualsTargetTypeConstraintRule_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalDsl.g:343:3: this_InCompartmentConstraintRule_9= ruleInCompartmentConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getConstraintRuleAccess().getInCompartmentConstraintRuleParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_InCompartmentConstraintRule_9=ruleInCompartmentConstraintRule();

                    state._fsp--;


                    			current = this_InCompartmentConstraintRule_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleContainsCompartmentConstrainRule"
    // InternalDsl.g:355:1: entryRuleContainsCompartmentConstrainRule returns [EObject current=null] : iv_ruleContainsCompartmentConstrainRule= ruleContainsCompartmentConstrainRule EOF ;
    public final EObject entryRuleContainsCompartmentConstrainRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainsCompartmentConstrainRule = null;


        try {
            // InternalDsl.g:355:73: (iv_ruleContainsCompartmentConstrainRule= ruleContainsCompartmentConstrainRule EOF )
            // InternalDsl.g:356:2: iv_ruleContainsCompartmentConstrainRule= ruleContainsCompartmentConstrainRule EOF
            {
             newCompositeNode(grammarAccess.getContainsCompartmentConstrainRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainsCompartmentConstrainRule=ruleContainsCompartmentConstrainRule();

            state._fsp--;

             current =iv_ruleContainsCompartmentConstrainRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainsCompartmentConstrainRule"


    // $ANTLR start "ruleContainsCompartmentConstrainRule"
    // InternalDsl.g:362:1: ruleContainsCompartmentConstrainRule returns [EObject current=null] : ( () otherlv_1= 'ContainsCompartment' otherlv_2= '(' otherlv_3= ')' ) ;
    public final EObject ruleContainsCompartmentConstrainRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDsl.g:368:2: ( ( () otherlv_1= 'ContainsCompartment' otherlv_2= '(' otherlv_3= ')' ) )
            // InternalDsl.g:369:2: ( () otherlv_1= 'ContainsCompartment' otherlv_2= '(' otherlv_3= ')' )
            {
            // InternalDsl.g:369:2: ( () otherlv_1= 'ContainsCompartment' otherlv_2= '(' otherlv_3= ')' )
            // InternalDsl.g:370:3: () otherlv_1= 'ContainsCompartment' otherlv_2= '(' otherlv_3= ')'
            {
            // InternalDsl.g:370:3: ()
            // InternalDsl.g:371:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContainsCompartmentConstrainRuleAccess().getContainsCompartmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getContainsCompartmentConstrainRuleAccess().getContainsCompartmentKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getContainsCompartmentConstrainRuleAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getContainsCompartmentConstrainRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainsCompartmentConstrainRule"


    // $ANTLR start "entryRuleIsTargetTypeConstraintRule"
    // InternalDsl.g:393:1: entryRuleIsTargetTypeConstraintRule returns [EObject current=null] : iv_ruleIsTargetTypeConstraintRule= ruleIsTargetTypeConstraintRule EOF ;
    public final EObject entryRuleIsTargetTypeConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsTargetTypeConstraintRule = null;


        try {
            // InternalDsl.g:393:67: (iv_ruleIsTargetTypeConstraintRule= ruleIsTargetTypeConstraintRule EOF )
            // InternalDsl.g:394:2: iv_ruleIsTargetTypeConstraintRule= ruleIsTargetTypeConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getIsTargetTypeConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsTargetTypeConstraintRule=ruleIsTargetTypeConstraintRule();

            state._fsp--;

             current =iv_ruleIsTargetTypeConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsTargetTypeConstraintRule"


    // $ANTLR start "ruleIsTargetTypeConstraintRule"
    // InternalDsl.g:400:1: ruleIsTargetTypeConstraintRule returns [EObject current=null] : ( () otherlv_1= 'IsTargetType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) ;
    public final EObject ruleIsTargetTypeConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:406:2: ( ( () otherlv_1= 'IsTargetType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) )
            // InternalDsl.g:407:2: ( () otherlv_1= 'IsTargetType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            {
            // InternalDsl.g:407:2: ( () otherlv_1= 'IsTargetType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            // InternalDsl.g:408:3: () otherlv_1= 'IsTargetType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')'
            {
            // InternalDsl.g:408:3: ()
            // InternalDsl.g:409:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIsTargetTypeConstraintRuleAccess().getIsTargetTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getIsTargetTypeConstraintRuleAccess().getIsTargetTypeKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getIsTargetTypeConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDsl.g:423:3: ( (lv_type_3_0= ruleFeatureTypeEnum ) )
            // InternalDsl.g:424:4: (lv_type_3_0= ruleFeatureTypeEnum )
            {
            // InternalDsl.g:424:4: (lv_type_3_0= ruleFeatureTypeEnum )
            // InternalDsl.g:425:5: lv_type_3_0= ruleFeatureTypeEnum
            {

            					newCompositeNode(grammarAccess.getIsTargetTypeConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_3_0=ruleFeatureTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsTargetTypeConstraintRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIsTargetTypeConstraintRuleAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsTargetTypeConstraintRule"


    // $ANTLR start "entryRuleIsParentConstraintRule"
    // InternalDsl.g:450:1: entryRuleIsParentConstraintRule returns [EObject current=null] : iv_ruleIsParentConstraintRule= ruleIsParentConstraintRule EOF ;
    public final EObject entryRuleIsParentConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsParentConstraintRule = null;


        try {
            // InternalDsl.g:450:63: (iv_ruleIsParentConstraintRule= ruleIsParentConstraintRule EOF )
            // InternalDsl.g:451:2: iv_ruleIsParentConstraintRule= ruleIsParentConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getIsParentConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsParentConstraintRule=ruleIsParentConstraintRule();

            state._fsp--;

             current =iv_ruleIsParentConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsParentConstraintRule"


    // $ANTLR start "ruleIsParentConstraintRule"
    // InternalDsl.g:457:1: ruleIsParentConstraintRule returns [EObject current=null] : ( () otherlv_1= 'IsParent' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) ;
    public final EObject ruleIsParentConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:463:2: ( ( () otherlv_1= 'IsParent' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) )
            // InternalDsl.g:464:2: ( () otherlv_1= 'IsParent' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            {
            // InternalDsl.g:464:2: ( () otherlv_1= 'IsParent' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            // InternalDsl.g:465:3: () otherlv_1= 'IsParent' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')'
            {
            // InternalDsl.g:465:3: ()
            // InternalDsl.g:466:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIsParentConstraintRuleAccess().getIsParentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getIsParentConstraintRuleAccess().getIsParentKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getIsParentConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDsl.g:480:3: ( (lv_type_3_0= ruleFeatureTypeEnum ) )
            // InternalDsl.g:481:4: (lv_type_3_0= ruleFeatureTypeEnum )
            {
            // InternalDsl.g:481:4: (lv_type_3_0= ruleFeatureTypeEnum )
            // InternalDsl.g:482:5: lv_type_3_0= ruleFeatureTypeEnum
            {

            					newCompositeNode(grammarAccess.getIsParentConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_3_0=ruleFeatureTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsParentConstraintRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIsParentConstraintRuleAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsParentConstraintRule"


    // $ANTLR start "entryRuleIsSourceTypeConstraintRule"
    // InternalDsl.g:507:1: entryRuleIsSourceTypeConstraintRule returns [EObject current=null] : iv_ruleIsSourceTypeConstraintRule= ruleIsSourceTypeConstraintRule EOF ;
    public final EObject entryRuleIsSourceTypeConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsSourceTypeConstraintRule = null;


        try {
            // InternalDsl.g:507:67: (iv_ruleIsSourceTypeConstraintRule= ruleIsSourceTypeConstraintRule EOF )
            // InternalDsl.g:508:2: iv_ruleIsSourceTypeConstraintRule= ruleIsSourceTypeConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getIsSourceTypeConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsSourceTypeConstraintRule=ruleIsSourceTypeConstraintRule();

            state._fsp--;

             current =iv_ruleIsSourceTypeConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsSourceTypeConstraintRule"


    // $ANTLR start "ruleIsSourceTypeConstraintRule"
    // InternalDsl.g:514:1: ruleIsSourceTypeConstraintRule returns [EObject current=null] : ( () otherlv_1= 'IsSourceType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) ;
    public final EObject ruleIsSourceTypeConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:520:2: ( ( () otherlv_1= 'IsSourceType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) )
            // InternalDsl.g:521:2: ( () otherlv_1= 'IsSourceType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            {
            // InternalDsl.g:521:2: ( () otherlv_1= 'IsSourceType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            // InternalDsl.g:522:3: () otherlv_1= 'IsSourceType' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')'
            {
            // InternalDsl.g:522:3: ()
            // InternalDsl.g:523:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIsSourceTypeConstraintRuleAccess().getIsSourceTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getIsSourceTypeConstraintRuleAccess().getIsSourceTypeKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getIsSourceTypeConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDsl.g:537:3: ( (lv_type_3_0= ruleFeatureTypeEnum ) )
            // InternalDsl.g:538:4: (lv_type_3_0= ruleFeatureTypeEnum )
            {
            // InternalDsl.g:538:4: (lv_type_3_0= ruleFeatureTypeEnum )
            // InternalDsl.g:539:5: lv_type_3_0= ruleFeatureTypeEnum
            {

            					newCompositeNode(grammarAccess.getIsSourceTypeConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_3_0=ruleFeatureTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsSourceTypeConstraintRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIsSourceTypeConstraintRuleAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsSourceTypeConstraintRule"


    // $ANTLR start "entryRuleIsTargetConstraintRule"
    // InternalDsl.g:564:1: entryRuleIsTargetConstraintRule returns [EObject current=null] : iv_ruleIsTargetConstraintRule= ruleIsTargetConstraintRule EOF ;
    public final EObject entryRuleIsTargetConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsTargetConstraintRule = null;


        try {
            // InternalDsl.g:564:63: (iv_ruleIsTargetConstraintRule= ruleIsTargetConstraintRule EOF )
            // InternalDsl.g:565:2: iv_ruleIsTargetConstraintRule= ruleIsTargetConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getIsTargetConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsTargetConstraintRule=ruleIsTargetConstraintRule();

            state._fsp--;

             current =iv_ruleIsTargetConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsTargetConstraintRule"


    // $ANTLR start "ruleIsTargetConstraintRule"
    // InternalDsl.g:571:1: ruleIsTargetConstraintRule returns [EObject current=null] : ( () otherlv_1= 'IsTarget' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) ;
    public final EObject ruleIsTargetConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:577:2: ( ( () otherlv_1= 'IsTarget' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' ) )
            // InternalDsl.g:578:2: ( () otherlv_1= 'IsTarget' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            {
            // InternalDsl.g:578:2: ( () otherlv_1= 'IsTarget' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')' )
            // InternalDsl.g:579:3: () otherlv_1= 'IsTarget' otherlv_2= '(' ( (lv_type_3_0= ruleFeatureTypeEnum ) ) otherlv_4= ')'
            {
            // InternalDsl.g:579:3: ()
            // InternalDsl.g:580:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIsTargetConstraintRuleAccess().getIsTargetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getIsTargetConstraintRuleAccess().getIsTargetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getIsTargetConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDsl.g:594:3: ( (lv_type_3_0= ruleFeatureTypeEnum ) )
            // InternalDsl.g:595:4: (lv_type_3_0= ruleFeatureTypeEnum )
            {
            // InternalDsl.g:595:4: (lv_type_3_0= ruleFeatureTypeEnum )
            // InternalDsl.g:596:5: lv_type_3_0= ruleFeatureTypeEnum
            {

            					newCompositeNode(grammarAccess.getIsTargetConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_type_3_0=ruleFeatureTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsTargetConstraintRuleRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIsTargetConstraintRuleAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsTargetConstraintRule"


    // $ANTLR start "entryRuleInCompartmentConstraintRule"
    // InternalDsl.g:621:1: entryRuleInCompartmentConstraintRule returns [EObject current=null] : iv_ruleInCompartmentConstraintRule= ruleInCompartmentConstraintRule EOF ;
    public final EObject entryRuleInCompartmentConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInCompartmentConstraintRule = null;


        try {
            // InternalDsl.g:621:68: (iv_ruleInCompartmentConstraintRule= ruleInCompartmentConstraintRule EOF )
            // InternalDsl.g:622:2: iv_ruleInCompartmentConstraintRule= ruleInCompartmentConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getInCompartmentConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInCompartmentConstraintRule=ruleInCompartmentConstraintRule();

            state._fsp--;

             current =iv_ruleInCompartmentConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInCompartmentConstraintRule"


    // $ANTLR start "ruleInCompartmentConstraintRule"
    // InternalDsl.g:628:1: ruleInCompartmentConstraintRule returns [EObject current=null] : ( () otherlv_1= 'InCompartment' otherlv_2= '(' otherlv_3= ')' ) ;
    public final EObject ruleInCompartmentConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDsl.g:634:2: ( ( () otherlv_1= 'InCompartment' otherlv_2= '(' otherlv_3= ')' ) )
            // InternalDsl.g:635:2: ( () otherlv_1= 'InCompartment' otherlv_2= '(' otherlv_3= ')' )
            {
            // InternalDsl.g:635:2: ( () otherlv_1= 'InCompartment' otherlv_2= '(' otherlv_3= ')' )
            // InternalDsl.g:636:3: () otherlv_1= 'InCompartment' otherlv_2= '(' otherlv_3= ')'
            {
            // InternalDsl.g:636:3: ()
            // InternalDsl.g:637:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInCompartmentConstraintRuleAccess().getInCompartmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getInCompartmentConstraintRuleAccess().getInCompartmentKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getInCompartmentConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInCompartmentConstraintRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInCompartmentConstraintRule"


    // $ANTLR start "entryRuleSourceEqualsTargetConstraintRule"
    // InternalDsl.g:659:1: entryRuleSourceEqualsTargetConstraintRule returns [EObject current=null] : iv_ruleSourceEqualsTargetConstraintRule= ruleSourceEqualsTargetConstraintRule EOF ;
    public final EObject entryRuleSourceEqualsTargetConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceEqualsTargetConstraintRule = null;


        try {
            // InternalDsl.g:659:73: (iv_ruleSourceEqualsTargetConstraintRule= ruleSourceEqualsTargetConstraintRule EOF )
            // InternalDsl.g:660:2: iv_ruleSourceEqualsTargetConstraintRule= ruleSourceEqualsTargetConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getSourceEqualsTargetConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSourceEqualsTargetConstraintRule=ruleSourceEqualsTargetConstraintRule();

            state._fsp--;

             current =iv_ruleSourceEqualsTargetConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSourceEqualsTargetConstraintRule"


    // $ANTLR start "ruleSourceEqualsTargetConstraintRule"
    // InternalDsl.g:666:1: ruleSourceEqualsTargetConstraintRule returns [EObject current=null] : ( () otherlv_1= 'SourceEqualsTarget' otherlv_2= '(' otherlv_3= ')' ) ;
    public final EObject ruleSourceEqualsTargetConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDsl.g:672:2: ( ( () otherlv_1= 'SourceEqualsTarget' otherlv_2= '(' otherlv_3= ')' ) )
            // InternalDsl.g:673:2: ( () otherlv_1= 'SourceEqualsTarget' otherlv_2= '(' otherlv_3= ')' )
            {
            // InternalDsl.g:673:2: ( () otherlv_1= 'SourceEqualsTarget' otherlv_2= '(' otherlv_3= ')' )
            // InternalDsl.g:674:3: () otherlv_1= 'SourceEqualsTarget' otherlv_2= '(' otherlv_3= ')'
            {
            // InternalDsl.g:674:3: ()
            // InternalDsl.g:675:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getSourceEqualsTargetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getSourceEqualsTargetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceEqualsTargetConstraintRule"


    // $ANTLR start "entryRuleSourceEqualsTargetTypeConstraintRule"
    // InternalDsl.g:697:1: entryRuleSourceEqualsTargetTypeConstraintRule returns [EObject current=null] : iv_ruleSourceEqualsTargetTypeConstraintRule= ruleSourceEqualsTargetTypeConstraintRule EOF ;
    public final EObject entryRuleSourceEqualsTargetTypeConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceEqualsTargetTypeConstraintRule = null;


        try {
            // InternalDsl.g:697:77: (iv_ruleSourceEqualsTargetTypeConstraintRule= ruleSourceEqualsTargetTypeConstraintRule EOF )
            // InternalDsl.g:698:2: iv_ruleSourceEqualsTargetTypeConstraintRule= ruleSourceEqualsTargetTypeConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getSourceEqualsTargetTypeConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSourceEqualsTargetTypeConstraintRule=ruleSourceEqualsTargetTypeConstraintRule();

            state._fsp--;

             current =iv_ruleSourceEqualsTargetTypeConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSourceEqualsTargetTypeConstraintRule"


    // $ANTLR start "ruleSourceEqualsTargetTypeConstraintRule"
    // InternalDsl.g:704:1: ruleSourceEqualsTargetTypeConstraintRule returns [EObject current=null] : ( () otherlv_1= 'SourceEqualsTargetType' otherlv_2= '(' otherlv_3= ')' ) ;
    public final EObject ruleSourceEqualsTargetTypeConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDsl.g:710:2: ( ( () otherlv_1= 'SourceEqualsTargetType' otherlv_2= '(' otherlv_3= ')' ) )
            // InternalDsl.g:711:2: ( () otherlv_1= 'SourceEqualsTargetType' otherlv_2= '(' otherlv_3= ')' )
            {
            // InternalDsl.g:711:2: ( () otherlv_1= 'SourceEqualsTargetType' otherlv_2= '(' otherlv_3= ')' )
            // InternalDsl.g:712:3: () otherlv_1= 'SourceEqualsTargetType' otherlv_2= '(' otherlv_3= ')'
            {
            // InternalDsl.g:712:3: ()
            // InternalDsl.g:713:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getSourceEqualsTargetTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getSourceEqualsTargetTypeKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceEqualsTargetTypeConstraintRule"


    // $ANTLR start "entryRuleFeatureRule"
    // InternalDsl.g:735:1: entryRuleFeatureRule returns [EObject current=null] : iv_ruleFeatureRule= ruleFeatureRule EOF ;
    public final EObject entryRuleFeatureRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureRule = null;


        try {
            // InternalDsl.g:735:52: (iv_ruleFeatureRule= ruleFeatureRule EOF )
            // InternalDsl.g:736:2: iv_ruleFeatureRule= ruleFeatureRule EOF
            {
             newCompositeNode(grammarAccess.getFeatureRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureRule=ruleFeatureRule();

            state._fsp--;

             current =iv_ruleFeatureRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureRule"


    // $ANTLR start "ruleFeatureRule"
    // InternalDsl.g:742:1: ruleFeatureRule returns [EObject current=null] : (this_IsFeature_0= ruleIsFeature | this_TrueFeatureRule_1= ruleTrueFeatureRule | this_FalseFeatureRule_2= ruleFalseFeatureRule ) ;
    public final EObject ruleFeatureRule() throws RecognitionException {
        EObject current = null;

        EObject this_IsFeature_0 = null;

        EObject this_TrueFeatureRule_1 = null;

        EObject this_FalseFeatureRule_2 = null;



        	enterRule();

        try {
            // InternalDsl.g:748:2: ( (this_IsFeature_0= ruleIsFeature | this_TrueFeatureRule_1= ruleTrueFeatureRule | this_FalseFeatureRule_2= ruleFalseFeatureRule ) )
            // InternalDsl.g:749:2: (this_IsFeature_0= ruleIsFeature | this_TrueFeatureRule_1= ruleTrueFeatureRule | this_FalseFeatureRule_2= ruleFalseFeatureRule )
            {
            // InternalDsl.g:749:2: (this_IsFeature_0= ruleIsFeature | this_TrueFeatureRule_1= ruleTrueFeatureRule | this_FalseFeatureRule_2= ruleFalseFeatureRule )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
                {
                alt5=1;
                }
                break;
            case 24:
                {
                alt5=2;
                }
                break;
            case 25:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDsl.g:750:3: this_IsFeature_0= ruleIsFeature
                    {

                    			newCompositeNode(grammarAccess.getFeatureRuleAccess().getIsFeatureParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsFeature_0=ruleIsFeature();

                    state._fsp--;


                    			current = this_IsFeature_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDsl.g:759:3: this_TrueFeatureRule_1= ruleTrueFeatureRule
                    {

                    			newCompositeNode(grammarAccess.getFeatureRuleAccess().getTrueFeatureRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrueFeatureRule_1=ruleTrueFeatureRule();

                    state._fsp--;


                    			current = this_TrueFeatureRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDsl.g:768:3: this_FalseFeatureRule_2= ruleFalseFeatureRule
                    {

                    			newCompositeNode(grammarAccess.getFeatureRuleAccess().getFalseFeatureRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FalseFeatureRule_2=ruleFalseFeatureRule();

                    state._fsp--;


                    			current = this_FalseFeatureRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureRule"


    // $ANTLR start "entryRuleIsFeature"
    // InternalDsl.g:780:1: entryRuleIsFeature returns [EObject current=null] : iv_ruleIsFeature= ruleIsFeature EOF ;
    public final EObject entryRuleIsFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsFeature = null;


        try {
            // InternalDsl.g:780:50: (iv_ruleIsFeature= ruleIsFeature EOF )
            // InternalDsl.g:781:2: iv_ruleIsFeature= ruleIsFeature EOF
            {
             newCompositeNode(grammarAccess.getIsFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsFeature=ruleIsFeature();

            state._fsp--;

             current =iv_ruleIsFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsFeature"


    // $ANTLR start "ruleIsFeature"
    // InternalDsl.g:787:1: ruleIsFeature returns [EObject current=null] : ( () ( (lv_featureName_1_0= ruleFeatureNameEnum ) ) ) ;
    public final EObject ruleIsFeature() throws RecognitionException {
        EObject current = null;

        Enumerator lv_featureName_1_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:793:2: ( ( () ( (lv_featureName_1_0= ruleFeatureNameEnum ) ) ) )
            // InternalDsl.g:794:2: ( () ( (lv_featureName_1_0= ruleFeatureNameEnum ) ) )
            {
            // InternalDsl.g:794:2: ( () ( (lv_featureName_1_0= ruleFeatureNameEnum ) ) )
            // InternalDsl.g:795:3: () ( (lv_featureName_1_0= ruleFeatureNameEnum ) )
            {
            // InternalDsl.g:795:3: ()
            // InternalDsl.g:796:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIsFeatureAccess().getIsFeatureAction_0(),
            					current);
            			

            }

            // InternalDsl.g:802:3: ( (lv_featureName_1_0= ruleFeatureNameEnum ) )
            // InternalDsl.g:803:4: (lv_featureName_1_0= ruleFeatureNameEnum )
            {
            // InternalDsl.g:803:4: (lv_featureName_1_0= ruleFeatureNameEnum )
            // InternalDsl.g:804:5: lv_featureName_1_0= ruleFeatureNameEnum
            {

            					newCompositeNode(grammarAccess.getIsFeatureAccess().getFeatureNameFeatureNameEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_featureName_1_0=ruleFeatureNameEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsFeatureRule());
            					}
            					set(
            						current,
            						"featureName",
            						lv_featureName_1_0,
            						"org.framed.iorm.editpolicydsl.Dsl.FeatureNameEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsFeature"


    // $ANTLR start "entryRuleTrueFeatureRule"
    // InternalDsl.g:825:1: entryRuleTrueFeatureRule returns [EObject current=null] : iv_ruleTrueFeatureRule= ruleTrueFeatureRule EOF ;
    public final EObject entryRuleTrueFeatureRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrueFeatureRule = null;


        try {
            // InternalDsl.g:825:56: (iv_ruleTrueFeatureRule= ruleTrueFeatureRule EOF )
            // InternalDsl.g:826:2: iv_ruleTrueFeatureRule= ruleTrueFeatureRule EOF
            {
             newCompositeNode(grammarAccess.getTrueFeatureRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrueFeatureRule=ruleTrueFeatureRule();

            state._fsp--;

             current =iv_ruleTrueFeatureRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrueFeatureRule"


    // $ANTLR start "ruleTrueFeatureRule"
    // InternalDsl.g:832:1: ruleTrueFeatureRule returns [EObject current=null] : ( () otherlv_1= 'true' ) ;
    public final EObject ruleTrueFeatureRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDsl.g:838:2: ( ( () otherlv_1= 'true' ) )
            // InternalDsl.g:839:2: ( () otherlv_1= 'true' )
            {
            // InternalDsl.g:839:2: ( () otherlv_1= 'true' )
            // InternalDsl.g:840:3: () otherlv_1= 'true'
            {
            // InternalDsl.g:840:3: ()
            // InternalDsl.g:841:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrueFeatureRuleAccess().getTrueFeatureRuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getTrueFeatureRuleAccess().getTrueKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrueFeatureRule"


    // $ANTLR start "entryRuleTrueConstraintRule"
    // InternalDsl.g:855:1: entryRuleTrueConstraintRule returns [EObject current=null] : iv_ruleTrueConstraintRule= ruleTrueConstraintRule EOF ;
    public final EObject entryRuleTrueConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrueConstraintRule = null;


        try {
            // InternalDsl.g:855:59: (iv_ruleTrueConstraintRule= ruleTrueConstraintRule EOF )
            // InternalDsl.g:856:2: iv_ruleTrueConstraintRule= ruleTrueConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getTrueConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrueConstraintRule=ruleTrueConstraintRule();

            state._fsp--;

             current =iv_ruleTrueConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrueConstraintRule"


    // $ANTLR start "ruleTrueConstraintRule"
    // InternalDsl.g:862:1: ruleTrueConstraintRule returns [EObject current=null] : ( () otherlv_1= 'true' ) ;
    public final EObject ruleTrueConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDsl.g:868:2: ( ( () otherlv_1= 'true' ) )
            // InternalDsl.g:869:2: ( () otherlv_1= 'true' )
            {
            // InternalDsl.g:869:2: ( () otherlv_1= 'true' )
            // InternalDsl.g:870:3: () otherlv_1= 'true'
            {
            // InternalDsl.g:870:3: ()
            // InternalDsl.g:871:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrueConstraintRuleAccess().getTrueConstraintRuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getTrueConstraintRuleAccess().getTrueKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrueConstraintRule"


    // $ANTLR start "entryRuleFalseFeatureRule"
    // InternalDsl.g:885:1: entryRuleFalseFeatureRule returns [EObject current=null] : iv_ruleFalseFeatureRule= ruleFalseFeatureRule EOF ;
    public final EObject entryRuleFalseFeatureRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFalseFeatureRule = null;


        try {
            // InternalDsl.g:885:57: (iv_ruleFalseFeatureRule= ruleFalseFeatureRule EOF )
            // InternalDsl.g:886:2: iv_ruleFalseFeatureRule= ruleFalseFeatureRule EOF
            {
             newCompositeNode(grammarAccess.getFalseFeatureRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFalseFeatureRule=ruleFalseFeatureRule();

            state._fsp--;

             current =iv_ruleFalseFeatureRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFalseFeatureRule"


    // $ANTLR start "ruleFalseFeatureRule"
    // InternalDsl.g:892:1: ruleFalseFeatureRule returns [EObject current=null] : ( () otherlv_1= 'false' ) ;
    public final EObject ruleFalseFeatureRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDsl.g:898:2: ( ( () otherlv_1= 'false' ) )
            // InternalDsl.g:899:2: ( () otherlv_1= 'false' )
            {
            // InternalDsl.g:899:2: ( () otherlv_1= 'false' )
            // InternalDsl.g:900:3: () otherlv_1= 'false'
            {
            // InternalDsl.g:900:3: ()
            // InternalDsl.g:901:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFalseFeatureRuleAccess().getFalseFeatureRuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFalseFeatureRuleAccess().getFalseKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFalseFeatureRule"


    // $ANTLR start "entryRuleFalseConstraintRule"
    // InternalDsl.g:915:1: entryRuleFalseConstraintRule returns [EObject current=null] : iv_ruleFalseConstraintRule= ruleFalseConstraintRule EOF ;
    public final EObject entryRuleFalseConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFalseConstraintRule = null;


        try {
            // InternalDsl.g:915:60: (iv_ruleFalseConstraintRule= ruleFalseConstraintRule EOF )
            // InternalDsl.g:916:2: iv_ruleFalseConstraintRule= ruleFalseConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getFalseConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFalseConstraintRule=ruleFalseConstraintRule();

            state._fsp--;

             current =iv_ruleFalseConstraintRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFalseConstraintRule"


    // $ANTLR start "ruleFalseConstraintRule"
    // InternalDsl.g:922:1: ruleFalseConstraintRule returns [EObject current=null] : ( () otherlv_1= 'false' ) ;
    public final EObject ruleFalseConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDsl.g:928:2: ( ( () otherlv_1= 'false' ) )
            // InternalDsl.g:929:2: ( () otherlv_1= 'false' )
            {
            // InternalDsl.g:929:2: ( () otherlv_1= 'false' )
            // InternalDsl.g:930:3: () otherlv_1= 'false'
            {
            // InternalDsl.g:930:3: ()
            // InternalDsl.g:931:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFalseConstraintRuleAccess().getFalseConstraintRuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFalseConstraintRuleAccess().getFalseKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFalseConstraintRule"


    // $ANTLR start "entryRuleFeatureExpression"
    // InternalDsl.g:945:1: entryRuleFeatureExpression returns [EObject current=null] : iv_ruleFeatureExpression= ruleFeatureExpression EOF ;
    public final EObject entryRuleFeatureExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureExpression = null;


        try {
            // InternalDsl.g:945:58: (iv_ruleFeatureExpression= ruleFeatureExpression EOF )
            // InternalDsl.g:946:2: iv_ruleFeatureExpression= ruleFeatureExpression EOF
            {
             newCompositeNode(grammarAccess.getFeatureExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureExpression=ruleFeatureExpression();

            state._fsp--;

             current =iv_ruleFeatureExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureExpression"


    // $ANTLR start "ruleFeatureExpression"
    // InternalDsl.g:952:1: ruleFeatureExpression returns [EObject current=null] : this_OrFeature_0= ruleOrFeature ;
    public final EObject ruleFeatureExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrFeature_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:958:2: (this_OrFeature_0= ruleOrFeature )
            // InternalDsl.g:959:2: this_OrFeature_0= ruleOrFeature
            {

            		newCompositeNode(grammarAccess.getFeatureExpressionAccess().getOrFeatureParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrFeature_0=ruleOrFeature();

            state._fsp--;


            		current = this_OrFeature_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureExpression"


    // $ANTLR start "entryRuleOrFeature"
    // InternalDsl.g:970:1: entryRuleOrFeature returns [EObject current=null] : iv_ruleOrFeature= ruleOrFeature EOF ;
    public final EObject entryRuleOrFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrFeature = null;


        try {
            // InternalDsl.g:970:50: (iv_ruleOrFeature= ruleOrFeature EOF )
            // InternalDsl.g:971:2: iv_ruleOrFeature= ruleOrFeature EOF
            {
             newCompositeNode(grammarAccess.getOrFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrFeature=ruleOrFeature();

            state._fsp--;

             current =iv_ruleOrFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrFeature"


    // $ANTLR start "ruleOrFeature"
    // InternalDsl.g:977:1: ruleOrFeature returns [EObject current=null] : (this_AndFeature_0= ruleAndFeature ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) ) )* ) ;
    public final EObject ruleOrFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndFeature_0 = null;

        EObject lv_rules_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:983:2: ( (this_AndFeature_0= ruleAndFeature ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) ) )* ) )
            // InternalDsl.g:984:2: (this_AndFeature_0= ruleAndFeature ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) ) )* )
            {
            // InternalDsl.g:984:2: (this_AndFeature_0= ruleAndFeature ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) ) )* )
            // InternalDsl.g:985:3: this_AndFeature_0= ruleAndFeature ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrFeatureAccess().getAndFeatureParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_AndFeature_0=ruleAndFeature();

            state._fsp--;


            			current = this_AndFeature_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDsl.g:993:3: ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==26) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDsl.g:994:4: () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndFeature ) )
            	    {
            	    // InternalDsl.g:994:4: ()
            	    // InternalDsl.g:995:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getOrFeatureAccess().getOrFeatureRuleRulesAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,26,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrFeatureAccess().getOrKeyword_1_1());
            	    			
            	    // InternalDsl.g:1005:4: ( (lv_rules_3_0= ruleAndFeature ) )
            	    // InternalDsl.g:1006:5: (lv_rules_3_0= ruleAndFeature )
            	    {
            	    // InternalDsl.g:1006:5: (lv_rules_3_0= ruleAndFeature )
            	    // InternalDsl.g:1007:6: lv_rules_3_0= ruleAndFeature
            	    {

            	    						newCompositeNode(grammarAccess.getOrFeatureAccess().getRulesAndFeatureParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_rules_3_0=ruleAndFeature();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrFeatureRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rules",
            	    							lv_rules_3_0,
            	    							"org.framed.iorm.editpolicydsl.Dsl.AndFeature");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrFeature"


    // $ANTLR start "entryRuleAndFeature"
    // InternalDsl.g:1029:1: entryRuleAndFeature returns [EObject current=null] : iv_ruleAndFeature= ruleAndFeature EOF ;
    public final EObject entryRuleAndFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndFeature = null;


        try {
            // InternalDsl.g:1029:51: (iv_ruleAndFeature= ruleAndFeature EOF )
            // InternalDsl.g:1030:2: iv_ruleAndFeature= ruleAndFeature EOF
            {
             newCompositeNode(grammarAccess.getAndFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndFeature=ruleAndFeature();

            state._fsp--;

             current =iv_ruleAndFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndFeature"


    // $ANTLR start "ruleAndFeature"
    // InternalDsl.g:1036:1: ruleAndFeature returns [EObject current=null] : (this_NotFeatureExpression_0= ruleNotFeatureExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) ) )* ) ;
    public final EObject ruleAndFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotFeatureExpression_0 = null;

        EObject lv_rules_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1042:2: ( (this_NotFeatureExpression_0= ruleNotFeatureExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) ) )* ) )
            // InternalDsl.g:1043:2: (this_NotFeatureExpression_0= ruleNotFeatureExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) ) )* )
            {
            // InternalDsl.g:1043:2: (this_NotFeatureExpression_0= ruleNotFeatureExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) ) )* )
            // InternalDsl.g:1044:3: this_NotFeatureExpression_0= ruleNotFeatureExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndFeatureAccess().getNotFeatureExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_NotFeatureExpression_0=ruleNotFeatureExpression();

            state._fsp--;


            			current = this_NotFeatureExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDsl.g:1052:3: ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDsl.g:1053:4: () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotFeatureExpression ) )
            	    {
            	    // InternalDsl.g:1053:4: ()
            	    // InternalDsl.g:1054:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getAndFeatureAccess().getAndFeatureRuleRulesAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndFeatureAccess().getAndKeyword_1_1());
            	    			
            	    // InternalDsl.g:1064:4: ( (lv_rules_3_0= ruleNotFeatureExpression ) )
            	    // InternalDsl.g:1065:5: (lv_rules_3_0= ruleNotFeatureExpression )
            	    {
            	    // InternalDsl.g:1065:5: (lv_rules_3_0= ruleNotFeatureExpression )
            	    // InternalDsl.g:1066:6: lv_rules_3_0= ruleNotFeatureExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndFeatureAccess().getRulesNotFeatureExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_rules_3_0=ruleNotFeatureExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndFeatureRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rules",
            	    							lv_rules_3_0,
            	    							"org.framed.iorm.editpolicydsl.Dsl.NotFeatureExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndFeature"


    // $ANTLR start "entryRuleNotFeatureExpression"
    // InternalDsl.g:1088:1: entryRuleNotFeatureExpression returns [EObject current=null] : iv_ruleNotFeatureExpression= ruleNotFeatureExpression EOF ;
    public final EObject entryRuleNotFeatureExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotFeatureExpression = null;


        try {
            // InternalDsl.g:1088:61: (iv_ruleNotFeatureExpression= ruleNotFeatureExpression EOF )
            // InternalDsl.g:1089:2: iv_ruleNotFeatureExpression= ruleNotFeatureExpression EOF
            {
             newCompositeNode(grammarAccess.getNotFeatureExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotFeatureExpression=ruleNotFeatureExpression();

            state._fsp--;

             current =iv_ruleNotFeatureExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotFeatureExpression"


    // $ANTLR start "ruleNotFeatureExpression"
    // InternalDsl.g:1095:1: ruleNotFeatureExpression returns [EObject current=null] : (this_PrimaryFeature_0= rulePrimaryFeature | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) ) ) ) ;
    public final EObject ruleNotFeatureExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_PrimaryFeature_0 = null;

        EObject lv_rule_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1101:2: ( (this_PrimaryFeature_0= rulePrimaryFeature | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) ) ) ) )
            // InternalDsl.g:1102:2: (this_PrimaryFeature_0= rulePrimaryFeature | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) ) ) )
            {
            // InternalDsl.g:1102:2: (this_PrimaryFeature_0= rulePrimaryFeature | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==12||(LA8_0>=24 && LA8_0<=25)||(LA8_0>=58 && LA8_0<=94)) ) {
                alt8=1;
            }
            else if ( (LA8_0==28) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalDsl.g:1103:3: this_PrimaryFeature_0= rulePrimaryFeature
                    {

                    			newCompositeNode(grammarAccess.getNotFeatureExpressionAccess().getPrimaryFeatureParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryFeature_0=rulePrimaryFeature();

                    state._fsp--;


                    			current = this_PrimaryFeature_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDsl.g:1112:3: (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) ) )
                    {
                    // InternalDsl.g:1112:3: (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) ) )
                    // InternalDsl.g:1113:4: otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryFeature ) )
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_14); 

                    				newLeafNode(otherlv_1, grammarAccess.getNotFeatureExpressionAccess().getExclamationMarkKeyword_1_0());
                    			
                    // InternalDsl.g:1117:4: ()
                    // InternalDsl.g:1118:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotFeatureExpressionAccess().getNotFeatureRuleAction_1_1(),
                    						current);
                    				

                    }

                    // InternalDsl.g:1124:4: ( (lv_rule_3_0= rulePrimaryFeature ) )
                    // InternalDsl.g:1125:5: (lv_rule_3_0= rulePrimaryFeature )
                    {
                    // InternalDsl.g:1125:5: (lv_rule_3_0= rulePrimaryFeature )
                    // InternalDsl.g:1126:6: lv_rule_3_0= rulePrimaryFeature
                    {

                    						newCompositeNode(grammarAccess.getNotFeatureExpressionAccess().getRulePrimaryFeatureParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rule_3_0=rulePrimaryFeature();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotFeatureExpressionRule());
                    						}
                    						set(
                    							current,
                    							"rule",
                    							lv_rule_3_0,
                    							"org.framed.iorm.editpolicydsl.Dsl.PrimaryFeature");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotFeatureExpression"


    // $ANTLR start "entryRulePrimaryFeature"
    // InternalDsl.g:1148:1: entryRulePrimaryFeature returns [EObject current=null] : iv_rulePrimaryFeature= rulePrimaryFeature EOF ;
    public final EObject entryRulePrimaryFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryFeature = null;


        try {
            // InternalDsl.g:1148:55: (iv_rulePrimaryFeature= rulePrimaryFeature EOF )
            // InternalDsl.g:1149:2: iv_rulePrimaryFeature= rulePrimaryFeature EOF
            {
             newCompositeNode(grammarAccess.getPrimaryFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryFeature=rulePrimaryFeature();

            state._fsp--;

             current =iv_rulePrimaryFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryFeature"


    // $ANTLR start "rulePrimaryFeature"
    // InternalDsl.g:1155:1: rulePrimaryFeature returns [EObject current=null] : (this_FeatureRule_0= ruleFeatureRule | (otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')' ) ) ;
    public final EObject rulePrimaryFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_FeatureRule_0 = null;

        EObject this_FeatureExpression_2 = null;



        	enterRule();

        try {
            // InternalDsl.g:1161:2: ( (this_FeatureRule_0= ruleFeatureRule | (otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')' ) ) )
            // InternalDsl.g:1162:2: (this_FeatureRule_0= ruleFeatureRule | (otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')' ) )
            {
            // InternalDsl.g:1162:2: (this_FeatureRule_0= ruleFeatureRule | (otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=24 && LA9_0<=25)||(LA9_0>=58 && LA9_0<=94)) ) {
                alt9=1;
            }
            else if ( (LA9_0==12) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalDsl.g:1163:3: this_FeatureRule_0= ruleFeatureRule
                    {

                    			newCompositeNode(grammarAccess.getPrimaryFeatureAccess().getFeatureRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FeatureRule_0=ruleFeatureRule();

                    state._fsp--;


                    			current = this_FeatureRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDsl.g:1172:3: (otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')' )
                    {
                    // InternalDsl.g:1172:3: (otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')' )
                    // InternalDsl.g:1173:4: otherlv_1= '(' this_FeatureExpression_2= ruleFeatureExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryFeatureAccess().getLeftParenthesisKeyword_1_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryFeatureAccess().getFeatureExpressionParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_8);
                    this_FeatureExpression_2=ruleFeatureExpression();

                    state._fsp--;


                    				current = this_FeatureExpression_2;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_3=(Token)match(input,13,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryFeatureAccess().getRightParenthesisKeyword_1_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryFeature"


    // $ANTLR start "entryRuleConstraintExpression"
    // InternalDsl.g:1194:1: entryRuleConstraintExpression returns [EObject current=null] : iv_ruleConstraintExpression= ruleConstraintExpression EOF ;
    public final EObject entryRuleConstraintExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintExpression = null;


        try {
            // InternalDsl.g:1194:61: (iv_ruleConstraintExpression= ruleConstraintExpression EOF )
            // InternalDsl.g:1195:2: iv_ruleConstraintExpression= ruleConstraintExpression EOF
            {
             newCompositeNode(grammarAccess.getConstraintExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintExpression=ruleConstraintExpression();

            state._fsp--;

             current =iv_ruleConstraintExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintExpression"


    // $ANTLR start "ruleConstraintExpression"
    // InternalDsl.g:1201:1: ruleConstraintExpression returns [EObject current=null] : this_ImplicationConstraint_0= ruleImplicationConstraint ;
    public final EObject ruleConstraintExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ImplicationConstraint_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1207:2: (this_ImplicationConstraint_0= ruleImplicationConstraint )
            // InternalDsl.g:1208:2: this_ImplicationConstraint_0= ruleImplicationConstraint
            {

            		newCompositeNode(grammarAccess.getConstraintExpressionAccess().getImplicationConstraintParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ImplicationConstraint_0=ruleImplicationConstraint();

            state._fsp--;


            		current = this_ImplicationConstraint_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintExpression"


    // $ANTLR start "entryRuleImplicationConstraint"
    // InternalDsl.g:1219:1: entryRuleImplicationConstraint returns [EObject current=null] : iv_ruleImplicationConstraint= ruleImplicationConstraint EOF ;
    public final EObject entryRuleImplicationConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationConstraint = null;


        try {
            // InternalDsl.g:1219:62: (iv_ruleImplicationConstraint= ruleImplicationConstraint EOF )
            // InternalDsl.g:1220:2: iv_ruleImplicationConstraint= ruleImplicationConstraint EOF
            {
             newCompositeNode(grammarAccess.getImplicationConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImplicationConstraint=ruleImplicationConstraint();

            state._fsp--;

             current =iv_ruleImplicationConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationConstraint"


    // $ANTLR start "ruleImplicationConstraint"
    // InternalDsl.g:1226:1: ruleImplicationConstraint returns [EObject current=null] : (this_OrConstraint_0= ruleOrConstraint ( () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) ) )? ) ;
    public final EObject ruleImplicationConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrConstraint_0 = null;

        EObject lv_rightRule_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1232:2: ( (this_OrConstraint_0= ruleOrConstraint ( () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) ) )? ) )
            // InternalDsl.g:1233:2: (this_OrConstraint_0= ruleOrConstraint ( () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) ) )? )
            {
            // InternalDsl.g:1233:2: (this_OrConstraint_0= ruleOrConstraint ( () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) ) )? )
            // InternalDsl.g:1234:3: this_OrConstraint_0= ruleOrConstraint ( () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) ) )?
            {

            			newCompositeNode(grammarAccess.getImplicationConstraintAccess().getOrConstraintParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_OrConstraint_0=ruleOrConstraint();

            state._fsp--;


            			current = this_OrConstraint_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDsl.g:1242:3: ( () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDsl.g:1243:4: () otherlv_2= '=>' ( (lv_rightRule_3_0= ruleOrConstraint ) )
                    {
                    // InternalDsl.g:1243:4: ()
                    // InternalDsl.g:1244:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getImplicationConstraintAccess().getImplicationConstraintRuleLeftRuleAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,29,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getImplicationConstraintAccess().getEqualsSignGreaterThanSignKeyword_1_1());
                    			
                    // InternalDsl.g:1254:4: ( (lv_rightRule_3_0= ruleOrConstraint ) )
                    // InternalDsl.g:1255:5: (lv_rightRule_3_0= ruleOrConstraint )
                    {
                    // InternalDsl.g:1255:5: (lv_rightRule_3_0= ruleOrConstraint )
                    // InternalDsl.g:1256:6: lv_rightRule_3_0= ruleOrConstraint
                    {

                    						newCompositeNode(grammarAccess.getImplicationConstraintAccess().getRightRuleOrConstraintParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rightRule_3_0=ruleOrConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImplicationConstraintRule());
                    						}
                    						set(
                    							current,
                    							"rightRule",
                    							lv_rightRule_3_0,
                    							"org.framed.iorm.editpolicydsl.Dsl.OrConstraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplicationConstraint"


    // $ANTLR start "entryRuleOrConstraint"
    // InternalDsl.g:1278:1: entryRuleOrConstraint returns [EObject current=null] : iv_ruleOrConstraint= ruleOrConstraint EOF ;
    public final EObject entryRuleOrConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrConstraint = null;


        try {
            // InternalDsl.g:1278:53: (iv_ruleOrConstraint= ruleOrConstraint EOF )
            // InternalDsl.g:1279:2: iv_ruleOrConstraint= ruleOrConstraint EOF
            {
             newCompositeNode(grammarAccess.getOrConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrConstraint=ruleOrConstraint();

            state._fsp--;

             current =iv_ruleOrConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrConstraint"


    // $ANTLR start "ruleOrConstraint"
    // InternalDsl.g:1285:1: ruleOrConstraint returns [EObject current=null] : (this_AndConstraint_0= ruleAndConstraint ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) ) )* ) ;
    public final EObject ruleOrConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndConstraint_0 = null;

        EObject lv_rules_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1291:2: ( (this_AndConstraint_0= ruleAndConstraint ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) ) )* ) )
            // InternalDsl.g:1292:2: (this_AndConstraint_0= ruleAndConstraint ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) ) )* )
            {
            // InternalDsl.g:1292:2: (this_AndConstraint_0= ruleAndConstraint ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) ) )* )
            // InternalDsl.g:1293:3: this_AndConstraint_0= ruleAndConstraint ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrConstraintAccess().getAndConstraintParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_AndConstraint_0=ruleAndConstraint();

            state._fsp--;


            			current = this_AndConstraint_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDsl.g:1301:3: ( () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDsl.g:1302:4: () otherlv_2= 'or' ( (lv_rules_3_0= ruleAndConstraint ) )
            	    {
            	    // InternalDsl.g:1302:4: ()
            	    // InternalDsl.g:1303:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getOrConstraintAccess().getOrConstraintRuleRulesAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,26,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrConstraintAccess().getOrKeyword_1_1());
            	    			
            	    // InternalDsl.g:1313:4: ( (lv_rules_3_0= ruleAndConstraint ) )
            	    // InternalDsl.g:1314:5: (lv_rules_3_0= ruleAndConstraint )
            	    {
            	    // InternalDsl.g:1314:5: (lv_rules_3_0= ruleAndConstraint )
            	    // InternalDsl.g:1315:6: lv_rules_3_0= ruleAndConstraint
            	    {

            	    						newCompositeNode(grammarAccess.getOrConstraintAccess().getRulesAndConstraintParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_rules_3_0=ruleAndConstraint();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrConstraintRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rules",
            	    							lv_rules_3_0,
            	    							"org.framed.iorm.editpolicydsl.Dsl.AndConstraint");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrConstraint"


    // $ANTLR start "entryRuleAndConstraint"
    // InternalDsl.g:1337:1: entryRuleAndConstraint returns [EObject current=null] : iv_ruleAndConstraint= ruleAndConstraint EOF ;
    public final EObject entryRuleAndConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndConstraint = null;


        try {
            // InternalDsl.g:1337:54: (iv_ruleAndConstraint= ruleAndConstraint EOF )
            // InternalDsl.g:1338:2: iv_ruleAndConstraint= ruleAndConstraint EOF
            {
             newCompositeNode(grammarAccess.getAndConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndConstraint=ruleAndConstraint();

            state._fsp--;

             current =iv_ruleAndConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndConstraint"


    // $ANTLR start "ruleAndConstraint"
    // InternalDsl.g:1344:1: ruleAndConstraint returns [EObject current=null] : (this_NotConstraintExpression_0= ruleNotConstraintExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) ) )* ) ;
    public final EObject ruleAndConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotConstraintExpression_0 = null;

        EObject lv_rules_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1350:2: ( (this_NotConstraintExpression_0= ruleNotConstraintExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) ) )* ) )
            // InternalDsl.g:1351:2: (this_NotConstraintExpression_0= ruleNotConstraintExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) ) )* )
            {
            // InternalDsl.g:1351:2: (this_NotConstraintExpression_0= ruleNotConstraintExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) ) )* )
            // InternalDsl.g:1352:3: this_NotConstraintExpression_0= ruleNotConstraintExpression ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndConstraintAccess().getNotConstraintExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_NotConstraintExpression_0=ruleNotConstraintExpression();

            state._fsp--;


            			current = this_NotConstraintExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDsl.g:1360:3: ( () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDsl.g:1361:4: () otherlv_2= 'and' ( (lv_rules_3_0= ruleNotConstraintExpression ) )
            	    {
            	    // InternalDsl.g:1361:4: ()
            	    // InternalDsl.g:1362:5: 
            	    {

            	    					current = forceCreateModelElementAndAdd(
            	    						grammarAccess.getAndConstraintAccess().getAndConstraintRuleRulesAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndConstraintAccess().getAndKeyword_1_1());
            	    			
            	    // InternalDsl.g:1372:4: ( (lv_rules_3_0= ruleNotConstraintExpression ) )
            	    // InternalDsl.g:1373:5: (lv_rules_3_0= ruleNotConstraintExpression )
            	    {
            	    // InternalDsl.g:1373:5: (lv_rules_3_0= ruleNotConstraintExpression )
            	    // InternalDsl.g:1374:6: lv_rules_3_0= ruleNotConstraintExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndConstraintAccess().getRulesNotConstraintExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_rules_3_0=ruleNotConstraintExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndConstraintRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rules",
            	    							lv_rules_3_0,
            	    							"org.framed.iorm.editpolicydsl.Dsl.NotConstraintExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndConstraint"


    // $ANTLR start "entryRuleNotConstraintExpression"
    // InternalDsl.g:1396:1: entryRuleNotConstraintExpression returns [EObject current=null] : iv_ruleNotConstraintExpression= ruleNotConstraintExpression EOF ;
    public final EObject entryRuleNotConstraintExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotConstraintExpression = null;


        try {
            // InternalDsl.g:1396:64: (iv_ruleNotConstraintExpression= ruleNotConstraintExpression EOF )
            // InternalDsl.g:1397:2: iv_ruleNotConstraintExpression= ruleNotConstraintExpression EOF
            {
             newCompositeNode(grammarAccess.getNotConstraintExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotConstraintExpression=ruleNotConstraintExpression();

            state._fsp--;

             current =iv_ruleNotConstraintExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotConstraintExpression"


    // $ANTLR start "ruleNotConstraintExpression"
    // InternalDsl.g:1403:1: ruleNotConstraintExpression returns [EObject current=null] : (this_PrimaryConstraint_0= rulePrimaryConstraint | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) ) ) ) ;
    public final EObject ruleNotConstraintExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_PrimaryConstraint_0 = null;

        EObject lv_rule_3_0 = null;



        	enterRule();

        try {
            // InternalDsl.g:1409:2: ( (this_PrimaryConstraint_0= rulePrimaryConstraint | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) ) ) ) )
            // InternalDsl.g:1410:2: (this_PrimaryConstraint_0= rulePrimaryConstraint | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) ) ) )
            {
            // InternalDsl.g:1410:2: (this_PrimaryConstraint_0= rulePrimaryConstraint | (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==12||(LA13_0>=16 && LA13_0<=25)) ) {
                alt13=1;
            }
            else if ( (LA13_0==28) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalDsl.g:1411:3: this_PrimaryConstraint_0= rulePrimaryConstraint
                    {

                    			newCompositeNode(grammarAccess.getNotConstraintExpressionAccess().getPrimaryConstraintParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryConstraint_0=rulePrimaryConstraint();

                    state._fsp--;


                    			current = this_PrimaryConstraint_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDsl.g:1420:3: (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) ) )
                    {
                    // InternalDsl.g:1420:3: (otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) ) )
                    // InternalDsl.g:1421:4: otherlv_1= '!' () ( (lv_rule_3_0= rulePrimaryConstraint ) )
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_16); 

                    				newLeafNode(otherlv_1, grammarAccess.getNotConstraintExpressionAccess().getExclamationMarkKeyword_1_0());
                    			
                    // InternalDsl.g:1425:4: ()
                    // InternalDsl.g:1426:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotConstraintExpressionAccess().getNotConstraintRuleAction_1_1(),
                    						current);
                    				

                    }

                    // InternalDsl.g:1432:4: ( (lv_rule_3_0= rulePrimaryConstraint ) )
                    // InternalDsl.g:1433:5: (lv_rule_3_0= rulePrimaryConstraint )
                    {
                    // InternalDsl.g:1433:5: (lv_rule_3_0= rulePrimaryConstraint )
                    // InternalDsl.g:1434:6: lv_rule_3_0= rulePrimaryConstraint
                    {

                    						newCompositeNode(grammarAccess.getNotConstraintExpressionAccess().getRulePrimaryConstraintParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rule_3_0=rulePrimaryConstraint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotConstraintExpressionRule());
                    						}
                    						set(
                    							current,
                    							"rule",
                    							lv_rule_3_0,
                    							"org.framed.iorm.editpolicydsl.Dsl.PrimaryConstraint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotConstraintExpression"


    // $ANTLR start "entryRulePrimaryConstraint"
    // InternalDsl.g:1456:1: entryRulePrimaryConstraint returns [EObject current=null] : iv_rulePrimaryConstraint= rulePrimaryConstraint EOF ;
    public final EObject entryRulePrimaryConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryConstraint = null;


        try {
            // InternalDsl.g:1456:58: (iv_rulePrimaryConstraint= rulePrimaryConstraint EOF )
            // InternalDsl.g:1457:2: iv_rulePrimaryConstraint= rulePrimaryConstraint EOF
            {
             newCompositeNode(grammarAccess.getPrimaryConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryConstraint=rulePrimaryConstraint();

            state._fsp--;

             current =iv_rulePrimaryConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryConstraint"


    // $ANTLR start "rulePrimaryConstraint"
    // InternalDsl.g:1463:1: rulePrimaryConstraint returns [EObject current=null] : (this_ConstraintRule_0= ruleConstraintRule | (otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')' ) ) ;
    public final EObject rulePrimaryConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_ConstraintRule_0 = null;

        EObject this_ConstraintExpression_2 = null;



        	enterRule();

        try {
            // InternalDsl.g:1469:2: ( (this_ConstraintRule_0= ruleConstraintRule | (otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')' ) ) )
            // InternalDsl.g:1470:2: (this_ConstraintRule_0= ruleConstraintRule | (otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')' ) )
            {
            // InternalDsl.g:1470:2: (this_ConstraintRule_0= ruleConstraintRule | (otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=16 && LA14_0<=25)) ) {
                alt14=1;
            }
            else if ( (LA14_0==12) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalDsl.g:1471:3: this_ConstraintRule_0= ruleConstraintRule
                    {

                    			newCompositeNode(grammarAccess.getPrimaryConstraintAccess().getConstraintRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstraintRule_0=ruleConstraintRule();

                    state._fsp--;


                    			current = this_ConstraintRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDsl.g:1480:3: (otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')' )
                    {
                    // InternalDsl.g:1480:3: (otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')' )
                    // InternalDsl.g:1481:4: otherlv_1= '(' this_ConstraintExpression_2= ruleConstraintExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryConstraintAccess().getLeftParenthesisKeyword_1_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryConstraintAccess().getConstraintExpressionParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_8);
                    this_ConstraintExpression_2=ruleConstraintExpression();

                    state._fsp--;


                    				current = this_ConstraintExpression_2;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_3=(Token)match(input,13,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryConstraintAccess().getRightParenthesisKeyword_1_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryConstraint"


    // $ANTLR start "ruleActionEnum"
    // InternalDsl.g:1502:1: ruleActionEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'Add' ) | (enumLiteral_1= 'Reconnect' ) | (enumLiteral_2= 'Create' ) | (enumLiteral_3= 'Start' ) | (enumLiteral_4= 'Execute' ) | (enumLiteral_5= 'Direct_Edit' ) | (enumLiteral_6= 'Add_Property' ) | (enumLiteral_7= 'Create_Attribute' ) | (enumLiteral_8= 'Create_Operation' ) | (enumLiteral_9= 'Create_Property' ) ) ;
    public final Enumerator ruleActionEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalDsl.g:1508:2: ( ( (enumLiteral_0= 'Add' ) | (enumLiteral_1= 'Reconnect' ) | (enumLiteral_2= 'Create' ) | (enumLiteral_3= 'Start' ) | (enumLiteral_4= 'Execute' ) | (enumLiteral_5= 'Direct_Edit' ) | (enumLiteral_6= 'Add_Property' ) | (enumLiteral_7= 'Create_Attribute' ) | (enumLiteral_8= 'Create_Operation' ) | (enumLiteral_9= 'Create_Property' ) ) )
            // InternalDsl.g:1509:2: ( (enumLiteral_0= 'Add' ) | (enumLiteral_1= 'Reconnect' ) | (enumLiteral_2= 'Create' ) | (enumLiteral_3= 'Start' ) | (enumLiteral_4= 'Execute' ) | (enumLiteral_5= 'Direct_Edit' ) | (enumLiteral_6= 'Add_Property' ) | (enumLiteral_7= 'Create_Attribute' ) | (enumLiteral_8= 'Create_Operation' ) | (enumLiteral_9= 'Create_Property' ) )
            {
            // InternalDsl.g:1509:2: ( (enumLiteral_0= 'Add' ) | (enumLiteral_1= 'Reconnect' ) | (enumLiteral_2= 'Create' ) | (enumLiteral_3= 'Start' ) | (enumLiteral_4= 'Execute' ) | (enumLiteral_5= 'Direct_Edit' ) | (enumLiteral_6= 'Add_Property' ) | (enumLiteral_7= 'Create_Attribute' ) | (enumLiteral_8= 'Create_Operation' ) | (enumLiteral_9= 'Create_Property' ) )
            int alt15=10;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt15=1;
                }
                break;
            case 31:
                {
                alt15=2;
                }
                break;
            case 32:
                {
                alt15=3;
                }
                break;
            case 33:
                {
                alt15=4;
                }
                break;
            case 34:
                {
                alt15=5;
                }
                break;
            case 35:
                {
                alt15=6;
                }
                break;
            case 36:
                {
                alt15=7;
                }
                break;
            case 37:
                {
                alt15=8;
                }
                break;
            case 38:
                {
                alt15=9;
                }
                break;
            case 39:
                {
                alt15=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalDsl.g:1510:3: (enumLiteral_0= 'Add' )
                    {
                    // InternalDsl.g:1510:3: (enumLiteral_0= 'Add' )
                    // InternalDsl.g:1511:4: enumLiteral_0= 'Add'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getActionEnumAccess().getAddEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:1518:3: (enumLiteral_1= 'Reconnect' )
                    {
                    // InternalDsl.g:1518:3: (enumLiteral_1= 'Reconnect' )
                    // InternalDsl.g:1519:4: enumLiteral_1= 'Reconnect'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getReconnectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getActionEnumAccess().getReconnectEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:1526:3: (enumLiteral_2= 'Create' )
                    {
                    // InternalDsl.g:1526:3: (enumLiteral_2= 'Create' )
                    // InternalDsl.g:1527:4: enumLiteral_2= 'Create'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getCreateEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getActionEnumAccess().getCreateEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:1534:3: (enumLiteral_3= 'Start' )
                    {
                    // InternalDsl.g:1534:3: (enumLiteral_3= 'Start' )
                    // InternalDsl.g:1535:4: enumLiteral_3= 'Start'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getStartEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getActionEnumAccess().getStartEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:1542:3: (enumLiteral_4= 'Execute' )
                    {
                    // InternalDsl.g:1542:3: (enumLiteral_4= 'Execute' )
                    // InternalDsl.g:1543:4: enumLiteral_4= 'Execute'
                    {
                    enumLiteral_4=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getExecuteEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getActionEnumAccess().getExecuteEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:1550:3: (enumLiteral_5= 'Direct_Edit' )
                    {
                    // InternalDsl.g:1550:3: (enumLiteral_5= 'Direct_Edit' )
                    // InternalDsl.g:1551:4: enumLiteral_5= 'Direct_Edit'
                    {
                    enumLiteral_5=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getDirect_EditEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getActionEnumAccess().getDirect_EditEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:1558:3: (enumLiteral_6= 'Add_Property' )
                    {
                    // InternalDsl.g:1558:3: (enumLiteral_6= 'Add_Property' )
                    // InternalDsl.g:1559:4: enumLiteral_6= 'Add_Property'
                    {
                    enumLiteral_6=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getAdd_PropertyEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getActionEnumAccess().getAdd_PropertyEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:1566:3: (enumLiteral_7= 'Create_Attribute' )
                    {
                    // InternalDsl.g:1566:3: (enumLiteral_7= 'Create_Attribute' )
                    // InternalDsl.g:1567:4: enumLiteral_7= 'Create_Attribute'
                    {
                    enumLiteral_7=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getCreate_AttributeEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getActionEnumAccess().getCreate_AttributeEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:1574:3: (enumLiteral_8= 'Create_Operation' )
                    {
                    // InternalDsl.g:1574:3: (enumLiteral_8= 'Create_Operation' )
                    // InternalDsl.g:1575:4: enumLiteral_8= 'Create_Operation'
                    {
                    enumLiteral_8=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getCreate_OperationEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getActionEnumAccess().getCreate_OperationEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:1582:3: (enumLiteral_9= 'Create_Property' )
                    {
                    // InternalDsl.g:1582:3: (enumLiteral_9= 'Create_Property' )
                    // InternalDsl.g:1583:4: enumLiteral_9= 'Create_Property'
                    {
                    enumLiteral_9=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getActionEnumAccess().getCreate_PropertyEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getActionEnumAccess().getCreate_PropertyEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionEnum"


    // $ANTLR start "ruleFeatureTypeEnum"
    // InternalDsl.g:1593:1: ruleFeatureTypeEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'Acyclic' ) | (enumLiteral_1= 'CompartmentType' ) | (enumLiteral_2= 'Cyclic' ) | (enumLiteral_3= 'DataType' ) | (enumLiteral_4= 'Fulfillment' ) | (enumLiteral_5= 'Inheritance' ) | (enumLiteral_6= 'Group' ) | (enumLiteral_7= 'Reflexive' ) | (enumLiteral_8= 'Relationship' ) | (enumLiteral_9= 'RelationshipExclusion' ) | (enumLiteral_10= 'RelationshipImplication' ) | (enumLiteral_11= 'RoleType' ) | (enumLiteral_12= 'RoleEquivalence' ) | (enumLiteral_13= 'RoleGroup' ) | (enumLiteral_14= 'RoleImplication' ) | (enumLiteral_15= 'RoleProhibition' ) | (enumLiteral_16= 'Irreflexive' ) | (enumLiteral_17= 'NaturalType' ) ) ;
    public final Enumerator ruleFeatureTypeEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;


        	enterRule();

        try {
            // InternalDsl.g:1599:2: ( ( (enumLiteral_0= 'Acyclic' ) | (enumLiteral_1= 'CompartmentType' ) | (enumLiteral_2= 'Cyclic' ) | (enumLiteral_3= 'DataType' ) | (enumLiteral_4= 'Fulfillment' ) | (enumLiteral_5= 'Inheritance' ) | (enumLiteral_6= 'Group' ) | (enumLiteral_7= 'Reflexive' ) | (enumLiteral_8= 'Relationship' ) | (enumLiteral_9= 'RelationshipExclusion' ) | (enumLiteral_10= 'RelationshipImplication' ) | (enumLiteral_11= 'RoleType' ) | (enumLiteral_12= 'RoleEquivalence' ) | (enumLiteral_13= 'RoleGroup' ) | (enumLiteral_14= 'RoleImplication' ) | (enumLiteral_15= 'RoleProhibition' ) | (enumLiteral_16= 'Irreflexive' ) | (enumLiteral_17= 'NaturalType' ) ) )
            // InternalDsl.g:1600:2: ( (enumLiteral_0= 'Acyclic' ) | (enumLiteral_1= 'CompartmentType' ) | (enumLiteral_2= 'Cyclic' ) | (enumLiteral_3= 'DataType' ) | (enumLiteral_4= 'Fulfillment' ) | (enumLiteral_5= 'Inheritance' ) | (enumLiteral_6= 'Group' ) | (enumLiteral_7= 'Reflexive' ) | (enumLiteral_8= 'Relationship' ) | (enumLiteral_9= 'RelationshipExclusion' ) | (enumLiteral_10= 'RelationshipImplication' ) | (enumLiteral_11= 'RoleType' ) | (enumLiteral_12= 'RoleEquivalence' ) | (enumLiteral_13= 'RoleGroup' ) | (enumLiteral_14= 'RoleImplication' ) | (enumLiteral_15= 'RoleProhibition' ) | (enumLiteral_16= 'Irreflexive' ) | (enumLiteral_17= 'NaturalType' ) )
            {
            // InternalDsl.g:1600:2: ( (enumLiteral_0= 'Acyclic' ) | (enumLiteral_1= 'CompartmentType' ) | (enumLiteral_2= 'Cyclic' ) | (enumLiteral_3= 'DataType' ) | (enumLiteral_4= 'Fulfillment' ) | (enumLiteral_5= 'Inheritance' ) | (enumLiteral_6= 'Group' ) | (enumLiteral_7= 'Reflexive' ) | (enumLiteral_8= 'Relationship' ) | (enumLiteral_9= 'RelationshipExclusion' ) | (enumLiteral_10= 'RelationshipImplication' ) | (enumLiteral_11= 'RoleType' ) | (enumLiteral_12= 'RoleEquivalence' ) | (enumLiteral_13= 'RoleGroup' ) | (enumLiteral_14= 'RoleImplication' ) | (enumLiteral_15= 'RoleProhibition' ) | (enumLiteral_16= 'Irreflexive' ) | (enumLiteral_17= 'NaturalType' ) )
            int alt16=18;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt16=1;
                }
                break;
            case 41:
                {
                alt16=2;
                }
                break;
            case 42:
                {
                alt16=3;
                }
                break;
            case 43:
                {
                alt16=4;
                }
                break;
            case 44:
                {
                alt16=5;
                }
                break;
            case 45:
                {
                alt16=6;
                }
                break;
            case 46:
                {
                alt16=7;
                }
                break;
            case 47:
                {
                alt16=8;
                }
                break;
            case 48:
                {
                alt16=9;
                }
                break;
            case 49:
                {
                alt16=10;
                }
                break;
            case 50:
                {
                alt16=11;
                }
                break;
            case 51:
                {
                alt16=12;
                }
                break;
            case 52:
                {
                alt16=13;
                }
                break;
            case 53:
                {
                alt16=14;
                }
                break;
            case 54:
                {
                alt16=15;
                }
                break;
            case 55:
                {
                alt16=16;
                }
                break;
            case 56:
                {
                alt16=17;
                }
                break;
            case 57:
                {
                alt16=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalDsl.g:1601:3: (enumLiteral_0= 'Acyclic' )
                    {
                    // InternalDsl.g:1601:3: (enumLiteral_0= 'Acyclic' )
                    // InternalDsl.g:1602:4: enumLiteral_0= 'Acyclic'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getAcyclicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFeatureTypeEnumAccess().getAcyclicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:1609:3: (enumLiteral_1= 'CompartmentType' )
                    {
                    // InternalDsl.g:1609:3: (enumLiteral_1= 'CompartmentType' )
                    // InternalDsl.g:1610:4: enumLiteral_1= 'CompartmentType'
                    {
                    enumLiteral_1=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getCompartmentTypeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFeatureTypeEnumAccess().getCompartmentTypeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:1617:3: (enumLiteral_2= 'Cyclic' )
                    {
                    // InternalDsl.g:1617:3: (enumLiteral_2= 'Cyclic' )
                    // InternalDsl.g:1618:4: enumLiteral_2= 'Cyclic'
                    {
                    enumLiteral_2=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getCyclicEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFeatureTypeEnumAccess().getCyclicEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:1625:3: (enumLiteral_3= 'DataType' )
                    {
                    // InternalDsl.g:1625:3: (enumLiteral_3= 'DataType' )
                    // InternalDsl.g:1626:4: enumLiteral_3= 'DataType'
                    {
                    enumLiteral_3=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getDataTypeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFeatureTypeEnumAccess().getDataTypeEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:1633:3: (enumLiteral_4= 'Fulfillment' )
                    {
                    // InternalDsl.g:1633:3: (enumLiteral_4= 'Fulfillment' )
                    // InternalDsl.g:1634:4: enumLiteral_4= 'Fulfillment'
                    {
                    enumLiteral_4=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getFulfillmentEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFeatureTypeEnumAccess().getFulfillmentEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:1641:3: (enumLiteral_5= 'Inheritance' )
                    {
                    // InternalDsl.g:1641:3: (enumLiteral_5= 'Inheritance' )
                    // InternalDsl.g:1642:4: enumLiteral_5= 'Inheritance'
                    {
                    enumLiteral_5=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getInheritanceEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFeatureTypeEnumAccess().getInheritanceEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:1649:3: (enumLiteral_6= 'Group' )
                    {
                    // InternalDsl.g:1649:3: (enumLiteral_6= 'Group' )
                    // InternalDsl.g:1650:4: enumLiteral_6= 'Group'
                    {
                    enumLiteral_6=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getGroupEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFeatureTypeEnumAccess().getGroupEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:1657:3: (enumLiteral_7= 'Reflexive' )
                    {
                    // InternalDsl.g:1657:3: (enumLiteral_7= 'Reflexive' )
                    // InternalDsl.g:1658:4: enumLiteral_7= 'Reflexive'
                    {
                    enumLiteral_7=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getReflexiveEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFeatureTypeEnumAccess().getReflexiveEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:1665:3: (enumLiteral_8= 'Relationship' )
                    {
                    // InternalDsl.g:1665:3: (enumLiteral_8= 'Relationship' )
                    // InternalDsl.g:1666:4: enumLiteral_8= 'Relationship'
                    {
                    enumLiteral_8=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRelationshipEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFeatureTypeEnumAccess().getRelationshipEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:1673:3: (enumLiteral_9= 'RelationshipExclusion' )
                    {
                    // InternalDsl.g:1673:3: (enumLiteral_9= 'RelationshipExclusion' )
                    // InternalDsl.g:1674:4: enumLiteral_9= 'RelationshipExclusion'
                    {
                    enumLiteral_9=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRelationshipExclusionEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFeatureTypeEnumAccess().getRelationshipExclusionEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDsl.g:1681:3: (enumLiteral_10= 'RelationshipImplication' )
                    {
                    // InternalDsl.g:1681:3: (enumLiteral_10= 'RelationshipImplication' )
                    // InternalDsl.g:1682:4: enumLiteral_10= 'RelationshipImplication'
                    {
                    enumLiteral_10=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRelationshipImplicationEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFeatureTypeEnumAccess().getRelationshipImplicationEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDsl.g:1689:3: (enumLiteral_11= 'RoleType' )
                    {
                    // InternalDsl.g:1689:3: (enumLiteral_11= 'RoleType' )
                    // InternalDsl.g:1690:4: enumLiteral_11= 'RoleType'
                    {
                    enumLiteral_11=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRoleTypeEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFeatureTypeEnumAccess().getRoleTypeEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDsl.g:1697:3: (enumLiteral_12= 'RoleEquivalence' )
                    {
                    // InternalDsl.g:1697:3: (enumLiteral_12= 'RoleEquivalence' )
                    // InternalDsl.g:1698:4: enumLiteral_12= 'RoleEquivalence'
                    {
                    enumLiteral_12=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRoleEquivalenceEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFeatureTypeEnumAccess().getRoleEquivalenceEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDsl.g:1705:3: (enumLiteral_13= 'RoleGroup' )
                    {
                    // InternalDsl.g:1705:3: (enumLiteral_13= 'RoleGroup' )
                    // InternalDsl.g:1706:4: enumLiteral_13= 'RoleGroup'
                    {
                    enumLiteral_13=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRoleGroupEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFeatureTypeEnumAccess().getRoleGroupEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDsl.g:1713:3: (enumLiteral_14= 'RoleImplication' )
                    {
                    // InternalDsl.g:1713:3: (enumLiteral_14= 'RoleImplication' )
                    // InternalDsl.g:1714:4: enumLiteral_14= 'RoleImplication'
                    {
                    enumLiteral_14=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRoleImplicationEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFeatureTypeEnumAccess().getRoleImplicationEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDsl.g:1721:3: (enumLiteral_15= 'RoleProhibition' )
                    {
                    // InternalDsl.g:1721:3: (enumLiteral_15= 'RoleProhibition' )
                    // InternalDsl.g:1722:4: enumLiteral_15= 'RoleProhibition'
                    {
                    enumLiteral_15=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getRoleProhibitionEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFeatureTypeEnumAccess().getRoleProhibitionEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDsl.g:1729:3: (enumLiteral_16= 'Irreflexive' )
                    {
                    // InternalDsl.g:1729:3: (enumLiteral_16= 'Irreflexive' )
                    // InternalDsl.g:1730:4: enumLiteral_16= 'Irreflexive'
                    {
                    enumLiteral_16=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getIrreflexiveEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFeatureTypeEnumAccess().getIrreflexiveEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDsl.g:1737:3: (enumLiteral_17= 'NaturalType' )
                    {
                    // InternalDsl.g:1737:3: (enumLiteral_17= 'NaturalType' )
                    // InternalDsl.g:1738:4: enumLiteral_17= 'NaturalType'
                    {
                    enumLiteral_17=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getFeatureTypeEnumAccess().getNaturalTypeEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFeatureTypeEnumAccess().getNaturalTypeEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureTypeEnum"


    // $ANTLR start "ruleFeatureNameEnum"
    // InternalDsl.g:1748:1: ruleFeatureNameEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'Compartment_Behavior' ) | (enumLiteral_1= 'Compartment_Inheritance' ) | (enumLiteral_2= 'Compartment_Properties' ) | (enumLiteral_3= 'Compartment_Structure' ) | (enumLiteral_4= 'Compartment_Types' ) | (enumLiteral_5= 'Contains_Compartments' ) | (enumLiteral_6= 'Compartments' ) | (enumLiteral_7= 'Data_Type_Inheritance' ) | (enumLiteral_8= 'Data_Types' ) | (enumLiteral_9= 'Dates' ) | (enumLiteral_10= 'Dependent' ) | (enumLiteral_11= 'Group_Constraints' ) | (enumLiteral_12= 'Inter_Relationship_Constraints' ) | (enumLiteral_13= 'Intra_Relationship_Constraints' ) | (enumLiteral_14= 'Naturals' ) | (enumLiteral_15= 'Occurrence_Constraints' ) | (enumLiteral_16= 'On_Compartments' ) | (enumLiteral_17= 'On_Relationships' ) | (enumLiteral_18= 'Parthood_Constraints' ) | (enumLiteral_19= 'Participants' ) | (enumLiteral_20= 'Playable' ) | (enumLiteral_21= 'Playable_by_Defining_Compartment' ) | (enumLiteral_22= 'Players' ) | (enumLiteral_23= 'Relationship_Cardinality' ) | (enumLiteral_24= 'Relationship_Constraints' ) | (enumLiteral_25= 'Relationships' ) | (enumLiteral_26= 'RML_Feature_Model' ) | (enumLiteral_27= 'Role_Behavior' ) | (enumLiteral_28= 'Role_Constraints' ) | (enumLiteral_29= 'Role_Equivalence' ) | (enumLiteral_30= 'Role_Implication' ) | (enumLiteral_31= 'Role_Inheritance' ) | (enumLiteral_32= 'Role_Prohibition' ) | (enumLiteral_33= 'Role_Properties' ) | (enumLiteral_34= 'Role_Structure' ) | (enumLiteral_35= 'Role_Types' ) | (enumLiteral_36= 'Roles' ) ) ;
    public final Enumerator ruleFeatureNameEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;
        Token enumLiteral_33=null;
        Token enumLiteral_34=null;
        Token enumLiteral_35=null;
        Token enumLiteral_36=null;


        	enterRule();

        try {
            // InternalDsl.g:1754:2: ( ( (enumLiteral_0= 'Compartment_Behavior' ) | (enumLiteral_1= 'Compartment_Inheritance' ) | (enumLiteral_2= 'Compartment_Properties' ) | (enumLiteral_3= 'Compartment_Structure' ) | (enumLiteral_4= 'Compartment_Types' ) | (enumLiteral_5= 'Contains_Compartments' ) | (enumLiteral_6= 'Compartments' ) | (enumLiteral_7= 'Data_Type_Inheritance' ) | (enumLiteral_8= 'Data_Types' ) | (enumLiteral_9= 'Dates' ) | (enumLiteral_10= 'Dependent' ) | (enumLiteral_11= 'Group_Constraints' ) | (enumLiteral_12= 'Inter_Relationship_Constraints' ) | (enumLiteral_13= 'Intra_Relationship_Constraints' ) | (enumLiteral_14= 'Naturals' ) | (enumLiteral_15= 'Occurrence_Constraints' ) | (enumLiteral_16= 'On_Compartments' ) | (enumLiteral_17= 'On_Relationships' ) | (enumLiteral_18= 'Parthood_Constraints' ) | (enumLiteral_19= 'Participants' ) | (enumLiteral_20= 'Playable' ) | (enumLiteral_21= 'Playable_by_Defining_Compartment' ) | (enumLiteral_22= 'Players' ) | (enumLiteral_23= 'Relationship_Cardinality' ) | (enumLiteral_24= 'Relationship_Constraints' ) | (enumLiteral_25= 'Relationships' ) | (enumLiteral_26= 'RML_Feature_Model' ) | (enumLiteral_27= 'Role_Behavior' ) | (enumLiteral_28= 'Role_Constraints' ) | (enumLiteral_29= 'Role_Equivalence' ) | (enumLiteral_30= 'Role_Implication' ) | (enumLiteral_31= 'Role_Inheritance' ) | (enumLiteral_32= 'Role_Prohibition' ) | (enumLiteral_33= 'Role_Properties' ) | (enumLiteral_34= 'Role_Structure' ) | (enumLiteral_35= 'Role_Types' ) | (enumLiteral_36= 'Roles' ) ) )
            // InternalDsl.g:1755:2: ( (enumLiteral_0= 'Compartment_Behavior' ) | (enumLiteral_1= 'Compartment_Inheritance' ) | (enumLiteral_2= 'Compartment_Properties' ) | (enumLiteral_3= 'Compartment_Structure' ) | (enumLiteral_4= 'Compartment_Types' ) | (enumLiteral_5= 'Contains_Compartments' ) | (enumLiteral_6= 'Compartments' ) | (enumLiteral_7= 'Data_Type_Inheritance' ) | (enumLiteral_8= 'Data_Types' ) | (enumLiteral_9= 'Dates' ) | (enumLiteral_10= 'Dependent' ) | (enumLiteral_11= 'Group_Constraints' ) | (enumLiteral_12= 'Inter_Relationship_Constraints' ) | (enumLiteral_13= 'Intra_Relationship_Constraints' ) | (enumLiteral_14= 'Naturals' ) | (enumLiteral_15= 'Occurrence_Constraints' ) | (enumLiteral_16= 'On_Compartments' ) | (enumLiteral_17= 'On_Relationships' ) | (enumLiteral_18= 'Parthood_Constraints' ) | (enumLiteral_19= 'Participants' ) | (enumLiteral_20= 'Playable' ) | (enumLiteral_21= 'Playable_by_Defining_Compartment' ) | (enumLiteral_22= 'Players' ) | (enumLiteral_23= 'Relationship_Cardinality' ) | (enumLiteral_24= 'Relationship_Constraints' ) | (enumLiteral_25= 'Relationships' ) | (enumLiteral_26= 'RML_Feature_Model' ) | (enumLiteral_27= 'Role_Behavior' ) | (enumLiteral_28= 'Role_Constraints' ) | (enumLiteral_29= 'Role_Equivalence' ) | (enumLiteral_30= 'Role_Implication' ) | (enumLiteral_31= 'Role_Inheritance' ) | (enumLiteral_32= 'Role_Prohibition' ) | (enumLiteral_33= 'Role_Properties' ) | (enumLiteral_34= 'Role_Structure' ) | (enumLiteral_35= 'Role_Types' ) | (enumLiteral_36= 'Roles' ) )
            {
            // InternalDsl.g:1755:2: ( (enumLiteral_0= 'Compartment_Behavior' ) | (enumLiteral_1= 'Compartment_Inheritance' ) | (enumLiteral_2= 'Compartment_Properties' ) | (enumLiteral_3= 'Compartment_Structure' ) | (enumLiteral_4= 'Compartment_Types' ) | (enumLiteral_5= 'Contains_Compartments' ) | (enumLiteral_6= 'Compartments' ) | (enumLiteral_7= 'Data_Type_Inheritance' ) | (enumLiteral_8= 'Data_Types' ) | (enumLiteral_9= 'Dates' ) | (enumLiteral_10= 'Dependent' ) | (enumLiteral_11= 'Group_Constraints' ) | (enumLiteral_12= 'Inter_Relationship_Constraints' ) | (enumLiteral_13= 'Intra_Relationship_Constraints' ) | (enumLiteral_14= 'Naturals' ) | (enumLiteral_15= 'Occurrence_Constraints' ) | (enumLiteral_16= 'On_Compartments' ) | (enumLiteral_17= 'On_Relationships' ) | (enumLiteral_18= 'Parthood_Constraints' ) | (enumLiteral_19= 'Participants' ) | (enumLiteral_20= 'Playable' ) | (enumLiteral_21= 'Playable_by_Defining_Compartment' ) | (enumLiteral_22= 'Players' ) | (enumLiteral_23= 'Relationship_Cardinality' ) | (enumLiteral_24= 'Relationship_Constraints' ) | (enumLiteral_25= 'Relationships' ) | (enumLiteral_26= 'RML_Feature_Model' ) | (enumLiteral_27= 'Role_Behavior' ) | (enumLiteral_28= 'Role_Constraints' ) | (enumLiteral_29= 'Role_Equivalence' ) | (enumLiteral_30= 'Role_Implication' ) | (enumLiteral_31= 'Role_Inheritance' ) | (enumLiteral_32= 'Role_Prohibition' ) | (enumLiteral_33= 'Role_Properties' ) | (enumLiteral_34= 'Role_Structure' ) | (enumLiteral_35= 'Role_Types' ) | (enumLiteral_36= 'Roles' ) )
            int alt17=37;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt17=1;
                }
                break;
            case 59:
                {
                alt17=2;
                }
                break;
            case 60:
                {
                alt17=3;
                }
                break;
            case 61:
                {
                alt17=4;
                }
                break;
            case 62:
                {
                alt17=5;
                }
                break;
            case 63:
                {
                alt17=6;
                }
                break;
            case 64:
                {
                alt17=7;
                }
                break;
            case 65:
                {
                alt17=8;
                }
                break;
            case 66:
                {
                alt17=9;
                }
                break;
            case 67:
                {
                alt17=10;
                }
                break;
            case 68:
                {
                alt17=11;
                }
                break;
            case 69:
                {
                alt17=12;
                }
                break;
            case 70:
                {
                alt17=13;
                }
                break;
            case 71:
                {
                alt17=14;
                }
                break;
            case 72:
                {
                alt17=15;
                }
                break;
            case 73:
                {
                alt17=16;
                }
                break;
            case 74:
                {
                alt17=17;
                }
                break;
            case 75:
                {
                alt17=18;
                }
                break;
            case 76:
                {
                alt17=19;
                }
                break;
            case 77:
                {
                alt17=20;
                }
                break;
            case 78:
                {
                alt17=21;
                }
                break;
            case 79:
                {
                alt17=22;
                }
                break;
            case 80:
                {
                alt17=23;
                }
                break;
            case 81:
                {
                alt17=24;
                }
                break;
            case 82:
                {
                alt17=25;
                }
                break;
            case 83:
                {
                alt17=26;
                }
                break;
            case 84:
                {
                alt17=27;
                }
                break;
            case 85:
                {
                alt17=28;
                }
                break;
            case 86:
                {
                alt17=29;
                }
                break;
            case 87:
                {
                alt17=30;
                }
                break;
            case 88:
                {
                alt17=31;
                }
                break;
            case 89:
                {
                alt17=32;
                }
                break;
            case 90:
                {
                alt17=33;
                }
                break;
            case 91:
                {
                alt17=34;
                }
                break;
            case 92:
                {
                alt17=35;
                }
                break;
            case 93:
                {
                alt17=36;
                }
                break;
            case 94:
                {
                alt17=37;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalDsl.g:1756:3: (enumLiteral_0= 'Compartment_Behavior' )
                    {
                    // InternalDsl.g:1756:3: (enumLiteral_0= 'Compartment_Behavior' )
                    // InternalDsl.g:1757:4: enumLiteral_0= 'Compartment_Behavior'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getCompartment_BehaviorEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFeatureNameEnumAccess().getCompartment_BehaviorEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:1764:3: (enumLiteral_1= 'Compartment_Inheritance' )
                    {
                    // InternalDsl.g:1764:3: (enumLiteral_1= 'Compartment_Inheritance' )
                    // InternalDsl.g:1765:4: enumLiteral_1= 'Compartment_Inheritance'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getCompartment_InheritanceEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFeatureNameEnumAccess().getCompartment_InheritanceEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:1772:3: (enumLiteral_2= 'Compartment_Properties' )
                    {
                    // InternalDsl.g:1772:3: (enumLiteral_2= 'Compartment_Properties' )
                    // InternalDsl.g:1773:4: enumLiteral_2= 'Compartment_Properties'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getCompartment_PropertiesEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFeatureNameEnumAccess().getCompartment_PropertiesEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:1780:3: (enumLiteral_3= 'Compartment_Structure' )
                    {
                    // InternalDsl.g:1780:3: (enumLiteral_3= 'Compartment_Structure' )
                    // InternalDsl.g:1781:4: enumLiteral_3= 'Compartment_Structure'
                    {
                    enumLiteral_3=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getCompartment_StructureEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFeatureNameEnumAccess().getCompartment_StructureEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:1788:3: (enumLiteral_4= 'Compartment_Types' )
                    {
                    // InternalDsl.g:1788:3: (enumLiteral_4= 'Compartment_Types' )
                    // InternalDsl.g:1789:4: enumLiteral_4= 'Compartment_Types'
                    {
                    enumLiteral_4=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getCompartment_TypesEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFeatureNameEnumAccess().getCompartment_TypesEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:1796:3: (enumLiteral_5= 'Contains_Compartments' )
                    {
                    // InternalDsl.g:1796:3: (enumLiteral_5= 'Contains_Compartments' )
                    // InternalDsl.g:1797:4: enumLiteral_5= 'Contains_Compartments'
                    {
                    enumLiteral_5=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getContains_CompartmentsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFeatureNameEnumAccess().getContains_CompartmentsEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:1804:3: (enumLiteral_6= 'Compartments' )
                    {
                    // InternalDsl.g:1804:3: (enumLiteral_6= 'Compartments' )
                    // InternalDsl.g:1805:4: enumLiteral_6= 'Compartments'
                    {
                    enumLiteral_6=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getCompartmentsEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFeatureNameEnumAccess().getCompartmentsEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:1812:3: (enumLiteral_7= 'Data_Type_Inheritance' )
                    {
                    // InternalDsl.g:1812:3: (enumLiteral_7= 'Data_Type_Inheritance' )
                    // InternalDsl.g:1813:4: enumLiteral_7= 'Data_Type_Inheritance'
                    {
                    enumLiteral_7=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getData_Type_InheritanceEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFeatureNameEnumAccess().getData_Type_InheritanceEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:1820:3: (enumLiteral_8= 'Data_Types' )
                    {
                    // InternalDsl.g:1820:3: (enumLiteral_8= 'Data_Types' )
                    // InternalDsl.g:1821:4: enumLiteral_8= 'Data_Types'
                    {
                    enumLiteral_8=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getData_TypesEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFeatureNameEnumAccess().getData_TypesEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:1828:3: (enumLiteral_9= 'Dates' )
                    {
                    // InternalDsl.g:1828:3: (enumLiteral_9= 'Dates' )
                    // InternalDsl.g:1829:4: enumLiteral_9= 'Dates'
                    {
                    enumLiteral_9=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getDatesEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFeatureNameEnumAccess().getDatesEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDsl.g:1836:3: (enumLiteral_10= 'Dependent' )
                    {
                    // InternalDsl.g:1836:3: (enumLiteral_10= 'Dependent' )
                    // InternalDsl.g:1837:4: enumLiteral_10= 'Dependent'
                    {
                    enumLiteral_10=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getDependentEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFeatureNameEnumAccess().getDependentEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDsl.g:1844:3: (enumLiteral_11= 'Group_Constraints' )
                    {
                    // InternalDsl.g:1844:3: (enumLiteral_11= 'Group_Constraints' )
                    // InternalDsl.g:1845:4: enumLiteral_11= 'Group_Constraints'
                    {
                    enumLiteral_11=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getGroup_ConstraintsEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFeatureNameEnumAccess().getGroup_ConstraintsEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDsl.g:1852:3: (enumLiteral_12= 'Inter_Relationship_Constraints' )
                    {
                    // InternalDsl.g:1852:3: (enumLiteral_12= 'Inter_Relationship_Constraints' )
                    // InternalDsl.g:1853:4: enumLiteral_12= 'Inter_Relationship_Constraints'
                    {
                    enumLiteral_12=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getInter_Relationship_ConstraintsEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFeatureNameEnumAccess().getInter_Relationship_ConstraintsEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDsl.g:1860:3: (enumLiteral_13= 'Intra_Relationship_Constraints' )
                    {
                    // InternalDsl.g:1860:3: (enumLiteral_13= 'Intra_Relationship_Constraints' )
                    // InternalDsl.g:1861:4: enumLiteral_13= 'Intra_Relationship_Constraints'
                    {
                    enumLiteral_13=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getIntra_Relationship_ConstraintsEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFeatureNameEnumAccess().getIntra_Relationship_ConstraintsEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDsl.g:1868:3: (enumLiteral_14= 'Naturals' )
                    {
                    // InternalDsl.g:1868:3: (enumLiteral_14= 'Naturals' )
                    // InternalDsl.g:1869:4: enumLiteral_14= 'Naturals'
                    {
                    enumLiteral_14=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getNaturalsEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFeatureNameEnumAccess().getNaturalsEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDsl.g:1876:3: (enumLiteral_15= 'Occurrence_Constraints' )
                    {
                    // InternalDsl.g:1876:3: (enumLiteral_15= 'Occurrence_Constraints' )
                    // InternalDsl.g:1877:4: enumLiteral_15= 'Occurrence_Constraints'
                    {
                    enumLiteral_15=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getOccurrence_ConstraintsEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFeatureNameEnumAccess().getOccurrence_ConstraintsEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDsl.g:1884:3: (enumLiteral_16= 'On_Compartments' )
                    {
                    // InternalDsl.g:1884:3: (enumLiteral_16= 'On_Compartments' )
                    // InternalDsl.g:1885:4: enumLiteral_16= 'On_Compartments'
                    {
                    enumLiteral_16=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getOn_CompartmentsEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFeatureNameEnumAccess().getOn_CompartmentsEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDsl.g:1892:3: (enumLiteral_17= 'On_Relationships' )
                    {
                    // InternalDsl.g:1892:3: (enumLiteral_17= 'On_Relationships' )
                    // InternalDsl.g:1893:4: enumLiteral_17= 'On_Relationships'
                    {
                    enumLiteral_17=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getOn_RelationshipsEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFeatureNameEnumAccess().getOn_RelationshipsEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDsl.g:1900:3: (enumLiteral_18= 'Parthood_Constraints' )
                    {
                    // InternalDsl.g:1900:3: (enumLiteral_18= 'Parthood_Constraints' )
                    // InternalDsl.g:1901:4: enumLiteral_18= 'Parthood_Constraints'
                    {
                    enumLiteral_18=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getParthood_ConstraintsEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFeatureNameEnumAccess().getParthood_ConstraintsEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDsl.g:1908:3: (enumLiteral_19= 'Participants' )
                    {
                    // InternalDsl.g:1908:3: (enumLiteral_19= 'Participants' )
                    // InternalDsl.g:1909:4: enumLiteral_19= 'Participants'
                    {
                    enumLiteral_19=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getParticipantsEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getFeatureNameEnumAccess().getParticipantsEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDsl.g:1916:3: (enumLiteral_20= 'Playable' )
                    {
                    // InternalDsl.g:1916:3: (enumLiteral_20= 'Playable' )
                    // InternalDsl.g:1917:4: enumLiteral_20= 'Playable'
                    {
                    enumLiteral_20=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getPlayableEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getFeatureNameEnumAccess().getPlayableEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDsl.g:1924:3: (enumLiteral_21= 'Playable_by_Defining_Compartment' )
                    {
                    // InternalDsl.g:1924:3: (enumLiteral_21= 'Playable_by_Defining_Compartment' )
                    // InternalDsl.g:1925:4: enumLiteral_21= 'Playable_by_Defining_Compartment'
                    {
                    enumLiteral_21=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getPlayable_by_Defining_CompartmentEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getFeatureNameEnumAccess().getPlayable_by_Defining_CompartmentEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDsl.g:1932:3: (enumLiteral_22= 'Players' )
                    {
                    // InternalDsl.g:1932:3: (enumLiteral_22= 'Players' )
                    // InternalDsl.g:1933:4: enumLiteral_22= 'Players'
                    {
                    enumLiteral_22=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getPlayersEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getFeatureNameEnumAccess().getPlayersEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDsl.g:1940:3: (enumLiteral_23= 'Relationship_Cardinality' )
                    {
                    // InternalDsl.g:1940:3: (enumLiteral_23= 'Relationship_Cardinality' )
                    // InternalDsl.g:1941:4: enumLiteral_23= 'Relationship_Cardinality'
                    {
                    enumLiteral_23=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRelationship_CardinalityEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getFeatureNameEnumAccess().getRelationship_CardinalityEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDsl.g:1948:3: (enumLiteral_24= 'Relationship_Constraints' )
                    {
                    // InternalDsl.g:1948:3: (enumLiteral_24= 'Relationship_Constraints' )
                    // InternalDsl.g:1949:4: enumLiteral_24= 'Relationship_Constraints'
                    {
                    enumLiteral_24=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRelationship_ConstraintsEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getFeatureNameEnumAccess().getRelationship_ConstraintsEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDsl.g:1956:3: (enumLiteral_25= 'Relationships' )
                    {
                    // InternalDsl.g:1956:3: (enumLiteral_25= 'Relationships' )
                    // InternalDsl.g:1957:4: enumLiteral_25= 'Relationships'
                    {
                    enumLiteral_25=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRelationshipsEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getFeatureNameEnumAccess().getRelationshipsEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDsl.g:1964:3: (enumLiteral_26= 'RML_Feature_Model' )
                    {
                    // InternalDsl.g:1964:3: (enumLiteral_26= 'RML_Feature_Model' )
                    // InternalDsl.g:1965:4: enumLiteral_26= 'RML_Feature_Model'
                    {
                    enumLiteral_26=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRML_Feature_ModelEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getFeatureNameEnumAccess().getRML_Feature_ModelEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDsl.g:1972:3: (enumLiteral_27= 'Role_Behavior' )
                    {
                    // InternalDsl.g:1972:3: (enumLiteral_27= 'Role_Behavior' )
                    // InternalDsl.g:1973:4: enumLiteral_27= 'Role_Behavior'
                    {
                    enumLiteral_27=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_BehaviorEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getFeatureNameEnumAccess().getRole_BehaviorEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDsl.g:1980:3: (enumLiteral_28= 'Role_Constraints' )
                    {
                    // InternalDsl.g:1980:3: (enumLiteral_28= 'Role_Constraints' )
                    // InternalDsl.g:1981:4: enumLiteral_28= 'Role_Constraints'
                    {
                    enumLiteral_28=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_ConstraintsEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getFeatureNameEnumAccess().getRole_ConstraintsEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDsl.g:1988:3: (enumLiteral_29= 'Role_Equivalence' )
                    {
                    // InternalDsl.g:1988:3: (enumLiteral_29= 'Role_Equivalence' )
                    // InternalDsl.g:1989:4: enumLiteral_29= 'Role_Equivalence'
                    {
                    enumLiteral_29=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_EquivalenceEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getFeatureNameEnumAccess().getRole_EquivalenceEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDsl.g:1996:3: (enumLiteral_30= 'Role_Implication' )
                    {
                    // InternalDsl.g:1996:3: (enumLiteral_30= 'Role_Implication' )
                    // InternalDsl.g:1997:4: enumLiteral_30= 'Role_Implication'
                    {
                    enumLiteral_30=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_ImplicationEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getFeatureNameEnumAccess().getRole_ImplicationEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDsl.g:2004:3: (enumLiteral_31= 'Role_Inheritance' )
                    {
                    // InternalDsl.g:2004:3: (enumLiteral_31= 'Role_Inheritance' )
                    // InternalDsl.g:2005:4: enumLiteral_31= 'Role_Inheritance'
                    {
                    enumLiteral_31=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_InheritanceEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getFeatureNameEnumAccess().getRole_InheritanceEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDsl.g:2012:3: (enumLiteral_32= 'Role_Prohibition' )
                    {
                    // InternalDsl.g:2012:3: (enumLiteral_32= 'Role_Prohibition' )
                    // InternalDsl.g:2013:4: enumLiteral_32= 'Role_Prohibition'
                    {
                    enumLiteral_32=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_ProhibitionEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getFeatureNameEnumAccess().getRole_ProhibitionEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDsl.g:2020:3: (enumLiteral_33= 'Role_Properties' )
                    {
                    // InternalDsl.g:2020:3: (enumLiteral_33= 'Role_Properties' )
                    // InternalDsl.g:2021:4: enumLiteral_33= 'Role_Properties'
                    {
                    enumLiteral_33=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_PropertiesEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getFeatureNameEnumAccess().getRole_PropertiesEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDsl.g:2028:3: (enumLiteral_34= 'Role_Structure' )
                    {
                    // InternalDsl.g:2028:3: (enumLiteral_34= 'Role_Structure' )
                    // InternalDsl.g:2029:4: enumLiteral_34= 'Role_Structure'
                    {
                    enumLiteral_34=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_StructureEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getFeatureNameEnumAccess().getRole_StructureEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDsl.g:2036:3: (enumLiteral_35= 'Role_Types' )
                    {
                    // InternalDsl.g:2036:3: (enumLiteral_35= 'Role_Types' )
                    // InternalDsl.g:2037:4: enumLiteral_35= 'Role_Types'
                    {
                    enumLiteral_35=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRole_TypesEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getFeatureNameEnumAccess().getRole_TypesEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDsl.g:2044:3: (enumLiteral_36= 'Roles' )
                    {
                    // InternalDsl.g:2044:3: (enumLiteral_36= 'Roles' )
                    // InternalDsl.g:2045:4: enumLiteral_36= 'Roles'
                    {
                    enumLiteral_36=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getFeatureNameEnumAccess().getRolesEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getFeatureNameEnumAccess().getRolesEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureNameEnum"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000FFC0000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000FFC0000800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x03FFFF0000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xFC00000013001000L,0x000000007FFFFFFFL});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000013FF1000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0xFC00000003001000L,0x000000007FFFFFFFL});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003FF1000L});

}