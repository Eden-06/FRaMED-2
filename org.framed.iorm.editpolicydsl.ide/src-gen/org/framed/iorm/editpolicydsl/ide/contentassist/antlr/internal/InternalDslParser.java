package org.framed.iorm.editpolicydsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.framed.iorm.editpolicydsl.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Add'", "'Reconnect'", "'Create'", "'Start'", "'Execute'", "'Direct_Edit'", "'Add_Property'", "'Create_Attribute'", "'Create_Operation'", "'Create_Property'", "'Acyclic'", "'CompartmentType'", "'Cyclic'", "'DataType'", "'Fulfillment'", "'Inheritance'", "'Group'", "'Reflexive'", "'Relationship'", "'RelationshipExclusion'", "'RelationshipImplication'", "'RoleType'", "'RoleEquivalence'", "'RoleGroup'", "'RoleImplication'", "'RoleProhibition'", "'Irreflexive'", "'NaturalType'", "'Compartment_Behavior'", "'Compartment_Inheritance'", "'Compartment_Properties'", "'Compartment_Structure'", "'Compartment_Types'", "'Contains_Compartments'", "'Compartments'", "'Data_Type_Inheritance'", "'Data_Types'", "'Dates'", "'Dependent'", "'Group_Constraints'", "'Inter_Relationship_Constraints'", "'Intra_Relationship_Constraints'", "'Naturals'", "'Occurrence_Constraints'", "'On_Compartments'", "'On_Relationships'", "'Parthood_Constraints'", "'Participants'", "'Playable'", "'Playable_by_Defining_Compartment'", "'Players'", "'Relationship_Cardinality'", "'Relationship_Constraints'", "'Relationships'", "'RML_Feature_Model'", "'Role_Behavior'", "'Role_Constraints'", "'Role_Equivalence'", "'Role_Implication'", "'Role_Inheritance'", "'Role_Prohibition'", "'Role_Properties'", "'Role_Structure'", "'Role_Types'", "'Roles'", "'('", "')'", "'when'", "';'", "'ContainsCompartment'", "'IsTargetType'", "'IsParent'", "'IsSourceType'", "'IsTarget'", "'InCompartment'", "'SourceEqualsTarget'", "'SourceEqualsTargetType'", "'true'", "'false'", "'or'", "'and'", "'!'", "'=>'", "'override'"
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

    	public void setGrammarAccess(DslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalDsl.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalDsl.g:54:1: ( ruleModel EOF )
            // InternalDsl.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalDsl.g:62:1: ruleModel : ( ( rule__Model__Group__0 )? ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:66:2: ( ( ( rule__Model__Group__0 )? ) )
            // InternalDsl.g:67:2: ( ( rule__Model__Group__0 )? )
            {
            // InternalDsl.g:67:2: ( ( rule__Model__Group__0 )? )
            // InternalDsl.g:68:3: ( rule__Model__Group__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalDsl.g:69:3: ( rule__Model__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=11 && LA1_0<=20)||LA1_0==94) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalDsl.g:69:4: rule__Model__Group__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePolicy"
    // InternalDsl.g:78:1: entryRulePolicy : rulePolicy EOF ;
    public final void entryRulePolicy() throws RecognitionException {
        try {
            // InternalDsl.g:79:1: ( rulePolicy EOF )
            // InternalDsl.g:80:1: rulePolicy EOF
            {
             before(grammarAccess.getPolicyRule()); 
            pushFollow(FOLLOW_1);
            rulePolicy();

            state._fsp--;

             after(grammarAccess.getPolicyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePolicy"


    // $ANTLR start "rulePolicy"
    // InternalDsl.g:87:1: rulePolicy : ( ( rule__Policy__Group__0 ) ) ;
    public final void rulePolicy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:91:2: ( ( ( rule__Policy__Group__0 ) ) )
            // InternalDsl.g:92:2: ( ( rule__Policy__Group__0 ) )
            {
            // InternalDsl.g:92:2: ( ( rule__Policy__Group__0 ) )
            // InternalDsl.g:93:3: ( rule__Policy__Group__0 )
            {
             before(grammarAccess.getPolicyAccess().getGroup()); 
            // InternalDsl.g:94:3: ( rule__Policy__Group__0 )
            // InternalDsl.g:94:4: rule__Policy__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Policy__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPolicyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePolicy"


    // $ANTLR start "entryRuleConstraintRule"
    // InternalDsl.g:103:1: entryRuleConstraintRule : ruleConstraintRule EOF ;
    public final void entryRuleConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:104:1: ( ruleConstraintRule EOF )
            // InternalDsl.g:105:1: ruleConstraintRule EOF
            {
             before(grammarAccess.getConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraintRule();

            state._fsp--;

             after(grammarAccess.getConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintRule"


    // $ANTLR start "ruleConstraintRule"
    // InternalDsl.g:112:1: ruleConstraintRule : ( ( rule__ConstraintRule__Alternatives ) ) ;
    public final void ruleConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:116:2: ( ( ( rule__ConstraintRule__Alternatives ) ) )
            // InternalDsl.g:117:2: ( ( rule__ConstraintRule__Alternatives ) )
            {
            // InternalDsl.g:117:2: ( ( rule__ConstraintRule__Alternatives ) )
            // InternalDsl.g:118:3: ( rule__ConstraintRule__Alternatives )
            {
             before(grammarAccess.getConstraintRuleAccess().getAlternatives()); 
            // InternalDsl.g:119:3: ( rule__ConstraintRule__Alternatives )
            // InternalDsl.g:119:4: rule__ConstraintRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstraintRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleContainsCompartmentConstrainRule"
    // InternalDsl.g:128:1: entryRuleContainsCompartmentConstrainRule : ruleContainsCompartmentConstrainRule EOF ;
    public final void entryRuleContainsCompartmentConstrainRule() throws RecognitionException {
        try {
            // InternalDsl.g:129:1: ( ruleContainsCompartmentConstrainRule EOF )
            // InternalDsl.g:130:1: ruleContainsCompartmentConstrainRule EOF
            {
             before(grammarAccess.getContainsCompartmentConstrainRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleContainsCompartmentConstrainRule();

            state._fsp--;

             after(grammarAccess.getContainsCompartmentConstrainRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContainsCompartmentConstrainRule"


    // $ANTLR start "ruleContainsCompartmentConstrainRule"
    // InternalDsl.g:137:1: ruleContainsCompartmentConstrainRule : ( ( rule__ContainsCompartmentConstrainRule__Group__0 ) ) ;
    public final void ruleContainsCompartmentConstrainRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:141:2: ( ( ( rule__ContainsCompartmentConstrainRule__Group__0 ) ) )
            // InternalDsl.g:142:2: ( ( rule__ContainsCompartmentConstrainRule__Group__0 ) )
            {
            // InternalDsl.g:142:2: ( ( rule__ContainsCompartmentConstrainRule__Group__0 ) )
            // InternalDsl.g:143:3: ( rule__ContainsCompartmentConstrainRule__Group__0 )
            {
             before(grammarAccess.getContainsCompartmentConstrainRuleAccess().getGroup()); 
            // InternalDsl.g:144:3: ( rule__ContainsCompartmentConstrainRule__Group__0 )
            // InternalDsl.g:144:4: rule__ContainsCompartmentConstrainRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ContainsCompartmentConstrainRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContainsCompartmentConstrainRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContainsCompartmentConstrainRule"


    // $ANTLR start "entryRuleIsTargetTypeConstraintRule"
    // InternalDsl.g:153:1: entryRuleIsTargetTypeConstraintRule : ruleIsTargetTypeConstraintRule EOF ;
    public final void entryRuleIsTargetTypeConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:154:1: ( ruleIsTargetTypeConstraintRule EOF )
            // InternalDsl.g:155:1: ruleIsTargetTypeConstraintRule EOF
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleIsTargetTypeConstraintRule();

            state._fsp--;

             after(grammarAccess.getIsTargetTypeConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsTargetTypeConstraintRule"


    // $ANTLR start "ruleIsTargetTypeConstraintRule"
    // InternalDsl.g:162:1: ruleIsTargetTypeConstraintRule : ( ( rule__IsTargetTypeConstraintRule__Group__0 ) ) ;
    public final void ruleIsTargetTypeConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:166:2: ( ( ( rule__IsTargetTypeConstraintRule__Group__0 ) ) )
            // InternalDsl.g:167:2: ( ( rule__IsTargetTypeConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:167:2: ( ( rule__IsTargetTypeConstraintRule__Group__0 ) )
            // InternalDsl.g:168:3: ( rule__IsTargetTypeConstraintRule__Group__0 )
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:169:3: ( rule__IsTargetTypeConstraintRule__Group__0 )
            // InternalDsl.g:169:4: rule__IsTargetTypeConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsTargetTypeConstraintRule"


    // $ANTLR start "entryRuleIsParentConstraintRule"
    // InternalDsl.g:178:1: entryRuleIsParentConstraintRule : ruleIsParentConstraintRule EOF ;
    public final void entryRuleIsParentConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:179:1: ( ruleIsParentConstraintRule EOF )
            // InternalDsl.g:180:1: ruleIsParentConstraintRule EOF
            {
             before(grammarAccess.getIsParentConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleIsParentConstraintRule();

            state._fsp--;

             after(grammarAccess.getIsParentConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsParentConstraintRule"


    // $ANTLR start "ruleIsParentConstraintRule"
    // InternalDsl.g:187:1: ruleIsParentConstraintRule : ( ( rule__IsParentConstraintRule__Group__0 ) ) ;
    public final void ruleIsParentConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:191:2: ( ( ( rule__IsParentConstraintRule__Group__0 ) ) )
            // InternalDsl.g:192:2: ( ( rule__IsParentConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:192:2: ( ( rule__IsParentConstraintRule__Group__0 ) )
            // InternalDsl.g:193:3: ( rule__IsParentConstraintRule__Group__0 )
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:194:3: ( rule__IsParentConstraintRule__Group__0 )
            // InternalDsl.g:194:4: rule__IsParentConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsParentConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsParentConstraintRule"


    // $ANTLR start "entryRuleIsSourceTypeConstraintRule"
    // InternalDsl.g:203:1: entryRuleIsSourceTypeConstraintRule : ruleIsSourceTypeConstraintRule EOF ;
    public final void entryRuleIsSourceTypeConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:204:1: ( ruleIsSourceTypeConstraintRule EOF )
            // InternalDsl.g:205:1: ruleIsSourceTypeConstraintRule EOF
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleIsSourceTypeConstraintRule();

            state._fsp--;

             after(grammarAccess.getIsSourceTypeConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsSourceTypeConstraintRule"


    // $ANTLR start "ruleIsSourceTypeConstraintRule"
    // InternalDsl.g:212:1: ruleIsSourceTypeConstraintRule : ( ( rule__IsSourceTypeConstraintRule__Group__0 ) ) ;
    public final void ruleIsSourceTypeConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:216:2: ( ( ( rule__IsSourceTypeConstraintRule__Group__0 ) ) )
            // InternalDsl.g:217:2: ( ( rule__IsSourceTypeConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:217:2: ( ( rule__IsSourceTypeConstraintRule__Group__0 ) )
            // InternalDsl.g:218:3: ( rule__IsSourceTypeConstraintRule__Group__0 )
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:219:3: ( rule__IsSourceTypeConstraintRule__Group__0 )
            // InternalDsl.g:219:4: rule__IsSourceTypeConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsSourceTypeConstraintRule"


    // $ANTLR start "entryRuleIsTargetConstraintRule"
    // InternalDsl.g:228:1: entryRuleIsTargetConstraintRule : ruleIsTargetConstraintRule EOF ;
    public final void entryRuleIsTargetConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:229:1: ( ruleIsTargetConstraintRule EOF )
            // InternalDsl.g:230:1: ruleIsTargetConstraintRule EOF
            {
             before(grammarAccess.getIsTargetConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleIsTargetConstraintRule();

            state._fsp--;

             after(grammarAccess.getIsTargetConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsTargetConstraintRule"


    // $ANTLR start "ruleIsTargetConstraintRule"
    // InternalDsl.g:237:1: ruleIsTargetConstraintRule : ( ( rule__IsTargetConstraintRule__Group__0 ) ) ;
    public final void ruleIsTargetConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:241:2: ( ( ( rule__IsTargetConstraintRule__Group__0 ) ) )
            // InternalDsl.g:242:2: ( ( rule__IsTargetConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:242:2: ( ( rule__IsTargetConstraintRule__Group__0 ) )
            // InternalDsl.g:243:3: ( rule__IsTargetConstraintRule__Group__0 )
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:244:3: ( rule__IsTargetConstraintRule__Group__0 )
            // InternalDsl.g:244:4: rule__IsTargetConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsTargetConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsTargetConstraintRule"


    // $ANTLR start "entryRuleInCompartmentConstraintRule"
    // InternalDsl.g:253:1: entryRuleInCompartmentConstraintRule : ruleInCompartmentConstraintRule EOF ;
    public final void entryRuleInCompartmentConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:254:1: ( ruleInCompartmentConstraintRule EOF )
            // InternalDsl.g:255:1: ruleInCompartmentConstraintRule EOF
            {
             before(grammarAccess.getInCompartmentConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleInCompartmentConstraintRule();

            state._fsp--;

             after(grammarAccess.getInCompartmentConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInCompartmentConstraintRule"


    // $ANTLR start "ruleInCompartmentConstraintRule"
    // InternalDsl.g:262:1: ruleInCompartmentConstraintRule : ( ( rule__InCompartmentConstraintRule__Group__0 ) ) ;
    public final void ruleInCompartmentConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:266:2: ( ( ( rule__InCompartmentConstraintRule__Group__0 ) ) )
            // InternalDsl.g:267:2: ( ( rule__InCompartmentConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:267:2: ( ( rule__InCompartmentConstraintRule__Group__0 ) )
            // InternalDsl.g:268:3: ( rule__InCompartmentConstraintRule__Group__0 )
            {
             before(grammarAccess.getInCompartmentConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:269:3: ( rule__InCompartmentConstraintRule__Group__0 )
            // InternalDsl.g:269:4: rule__InCompartmentConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InCompartmentConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInCompartmentConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInCompartmentConstraintRule"


    // $ANTLR start "entryRuleSourceEqualsTargetConstraintRule"
    // InternalDsl.g:278:1: entryRuleSourceEqualsTargetConstraintRule : ruleSourceEqualsTargetConstraintRule EOF ;
    public final void entryRuleSourceEqualsTargetConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:279:1: ( ruleSourceEqualsTargetConstraintRule EOF )
            // InternalDsl.g:280:1: ruleSourceEqualsTargetConstraintRule EOF
            {
             before(grammarAccess.getSourceEqualsTargetConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleSourceEqualsTargetConstraintRule();

            state._fsp--;

             after(grammarAccess.getSourceEqualsTargetConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSourceEqualsTargetConstraintRule"


    // $ANTLR start "ruleSourceEqualsTargetConstraintRule"
    // InternalDsl.g:287:1: ruleSourceEqualsTargetConstraintRule : ( ( rule__SourceEqualsTargetConstraintRule__Group__0 ) ) ;
    public final void ruleSourceEqualsTargetConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:291:2: ( ( ( rule__SourceEqualsTargetConstraintRule__Group__0 ) ) )
            // InternalDsl.g:292:2: ( ( rule__SourceEqualsTargetConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:292:2: ( ( rule__SourceEqualsTargetConstraintRule__Group__0 ) )
            // InternalDsl.g:293:3: ( rule__SourceEqualsTargetConstraintRule__Group__0 )
            {
             before(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:294:3: ( rule__SourceEqualsTargetConstraintRule__Group__0 )
            // InternalDsl.g:294:4: rule__SourceEqualsTargetConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSourceEqualsTargetConstraintRule"


    // $ANTLR start "entryRuleSourceEqualsTargetTypeConstraintRule"
    // InternalDsl.g:303:1: entryRuleSourceEqualsTargetTypeConstraintRule : ruleSourceEqualsTargetTypeConstraintRule EOF ;
    public final void entryRuleSourceEqualsTargetTypeConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:304:1: ( ruleSourceEqualsTargetTypeConstraintRule EOF )
            // InternalDsl.g:305:1: ruleSourceEqualsTargetTypeConstraintRule EOF
            {
             before(grammarAccess.getSourceEqualsTargetTypeConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleSourceEqualsTargetTypeConstraintRule();

            state._fsp--;

             after(grammarAccess.getSourceEqualsTargetTypeConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSourceEqualsTargetTypeConstraintRule"


    // $ANTLR start "ruleSourceEqualsTargetTypeConstraintRule"
    // InternalDsl.g:312:1: ruleSourceEqualsTargetTypeConstraintRule : ( ( rule__SourceEqualsTargetTypeConstraintRule__Group__0 ) ) ;
    public final void ruleSourceEqualsTargetTypeConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:316:2: ( ( ( rule__SourceEqualsTargetTypeConstraintRule__Group__0 ) ) )
            // InternalDsl.g:317:2: ( ( rule__SourceEqualsTargetTypeConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:317:2: ( ( rule__SourceEqualsTargetTypeConstraintRule__Group__0 ) )
            // InternalDsl.g:318:3: ( rule__SourceEqualsTargetTypeConstraintRule__Group__0 )
            {
             before(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:319:3: ( rule__SourceEqualsTargetTypeConstraintRule__Group__0 )
            // InternalDsl.g:319:4: rule__SourceEqualsTargetTypeConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetTypeConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSourceEqualsTargetTypeConstraintRule"


    // $ANTLR start "entryRuleFeatureRule"
    // InternalDsl.g:328:1: entryRuleFeatureRule : ruleFeatureRule EOF ;
    public final void entryRuleFeatureRule() throws RecognitionException {
        try {
            // InternalDsl.g:329:1: ( ruleFeatureRule EOF )
            // InternalDsl.g:330:1: ruleFeatureRule EOF
            {
             before(grammarAccess.getFeatureRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFeatureRule();

            state._fsp--;

             after(grammarAccess.getFeatureRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureRule"


    // $ANTLR start "ruleFeatureRule"
    // InternalDsl.g:337:1: ruleFeatureRule : ( ( rule__FeatureRule__Alternatives ) ) ;
    public final void ruleFeatureRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:341:2: ( ( ( rule__FeatureRule__Alternatives ) ) )
            // InternalDsl.g:342:2: ( ( rule__FeatureRule__Alternatives ) )
            {
            // InternalDsl.g:342:2: ( ( rule__FeatureRule__Alternatives ) )
            // InternalDsl.g:343:3: ( rule__FeatureRule__Alternatives )
            {
             before(grammarAccess.getFeatureRuleAccess().getAlternatives()); 
            // InternalDsl.g:344:3: ( rule__FeatureRule__Alternatives )
            // InternalDsl.g:344:4: rule__FeatureRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FeatureRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFeatureRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureRule"


    // $ANTLR start "entryRuleIsFeature"
    // InternalDsl.g:353:1: entryRuleIsFeature : ruleIsFeature EOF ;
    public final void entryRuleIsFeature() throws RecognitionException {
        try {
            // InternalDsl.g:354:1: ( ruleIsFeature EOF )
            // InternalDsl.g:355:1: ruleIsFeature EOF
            {
             before(grammarAccess.getIsFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleIsFeature();

            state._fsp--;

             after(grammarAccess.getIsFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsFeature"


    // $ANTLR start "ruleIsFeature"
    // InternalDsl.g:362:1: ruleIsFeature : ( ( rule__IsFeature__Group__0 ) ) ;
    public final void ruleIsFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:366:2: ( ( ( rule__IsFeature__Group__0 ) ) )
            // InternalDsl.g:367:2: ( ( rule__IsFeature__Group__0 ) )
            {
            // InternalDsl.g:367:2: ( ( rule__IsFeature__Group__0 ) )
            // InternalDsl.g:368:3: ( rule__IsFeature__Group__0 )
            {
             before(grammarAccess.getIsFeatureAccess().getGroup()); 
            // InternalDsl.g:369:3: ( rule__IsFeature__Group__0 )
            // InternalDsl.g:369:4: rule__IsFeature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsFeature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsFeatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsFeature"


    // $ANTLR start "entryRuleTrueFeatureRule"
    // InternalDsl.g:378:1: entryRuleTrueFeatureRule : ruleTrueFeatureRule EOF ;
    public final void entryRuleTrueFeatureRule() throws RecognitionException {
        try {
            // InternalDsl.g:379:1: ( ruleTrueFeatureRule EOF )
            // InternalDsl.g:380:1: ruleTrueFeatureRule EOF
            {
             before(grammarAccess.getTrueFeatureRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleTrueFeatureRule();

            state._fsp--;

             after(grammarAccess.getTrueFeatureRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrueFeatureRule"


    // $ANTLR start "ruleTrueFeatureRule"
    // InternalDsl.g:387:1: ruleTrueFeatureRule : ( ( rule__TrueFeatureRule__Group__0 ) ) ;
    public final void ruleTrueFeatureRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:391:2: ( ( ( rule__TrueFeatureRule__Group__0 ) ) )
            // InternalDsl.g:392:2: ( ( rule__TrueFeatureRule__Group__0 ) )
            {
            // InternalDsl.g:392:2: ( ( rule__TrueFeatureRule__Group__0 ) )
            // InternalDsl.g:393:3: ( rule__TrueFeatureRule__Group__0 )
            {
             before(grammarAccess.getTrueFeatureRuleAccess().getGroup()); 
            // InternalDsl.g:394:3: ( rule__TrueFeatureRule__Group__0 )
            // InternalDsl.g:394:4: rule__TrueFeatureRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrueFeatureRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrueFeatureRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrueFeatureRule"


    // $ANTLR start "entryRuleTrueConstraintRule"
    // InternalDsl.g:403:1: entryRuleTrueConstraintRule : ruleTrueConstraintRule EOF ;
    public final void entryRuleTrueConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:404:1: ( ruleTrueConstraintRule EOF )
            // InternalDsl.g:405:1: ruleTrueConstraintRule EOF
            {
             before(grammarAccess.getTrueConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleTrueConstraintRule();

            state._fsp--;

             after(grammarAccess.getTrueConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrueConstraintRule"


    // $ANTLR start "ruleTrueConstraintRule"
    // InternalDsl.g:412:1: ruleTrueConstraintRule : ( ( rule__TrueConstraintRule__Group__0 ) ) ;
    public final void ruleTrueConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:416:2: ( ( ( rule__TrueConstraintRule__Group__0 ) ) )
            // InternalDsl.g:417:2: ( ( rule__TrueConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:417:2: ( ( rule__TrueConstraintRule__Group__0 ) )
            // InternalDsl.g:418:3: ( rule__TrueConstraintRule__Group__0 )
            {
             before(grammarAccess.getTrueConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:419:3: ( rule__TrueConstraintRule__Group__0 )
            // InternalDsl.g:419:4: rule__TrueConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrueConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrueConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrueConstraintRule"


    // $ANTLR start "entryRuleFalseFeatureRule"
    // InternalDsl.g:428:1: entryRuleFalseFeatureRule : ruleFalseFeatureRule EOF ;
    public final void entryRuleFalseFeatureRule() throws RecognitionException {
        try {
            // InternalDsl.g:429:1: ( ruleFalseFeatureRule EOF )
            // InternalDsl.g:430:1: ruleFalseFeatureRule EOF
            {
             before(grammarAccess.getFalseFeatureRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFalseFeatureRule();

            state._fsp--;

             after(grammarAccess.getFalseFeatureRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFalseFeatureRule"


    // $ANTLR start "ruleFalseFeatureRule"
    // InternalDsl.g:437:1: ruleFalseFeatureRule : ( ( rule__FalseFeatureRule__Group__0 ) ) ;
    public final void ruleFalseFeatureRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:441:2: ( ( ( rule__FalseFeatureRule__Group__0 ) ) )
            // InternalDsl.g:442:2: ( ( rule__FalseFeatureRule__Group__0 ) )
            {
            // InternalDsl.g:442:2: ( ( rule__FalseFeatureRule__Group__0 ) )
            // InternalDsl.g:443:3: ( rule__FalseFeatureRule__Group__0 )
            {
             before(grammarAccess.getFalseFeatureRuleAccess().getGroup()); 
            // InternalDsl.g:444:3: ( rule__FalseFeatureRule__Group__0 )
            // InternalDsl.g:444:4: rule__FalseFeatureRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FalseFeatureRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFalseFeatureRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFalseFeatureRule"


    // $ANTLR start "entryRuleFalseConstraintRule"
    // InternalDsl.g:453:1: entryRuleFalseConstraintRule : ruleFalseConstraintRule EOF ;
    public final void entryRuleFalseConstraintRule() throws RecognitionException {
        try {
            // InternalDsl.g:454:1: ( ruleFalseConstraintRule EOF )
            // InternalDsl.g:455:1: ruleFalseConstraintRule EOF
            {
             before(grammarAccess.getFalseConstraintRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleFalseConstraintRule();

            state._fsp--;

             after(grammarAccess.getFalseConstraintRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFalseConstraintRule"


    // $ANTLR start "ruleFalseConstraintRule"
    // InternalDsl.g:462:1: ruleFalseConstraintRule : ( ( rule__FalseConstraintRule__Group__0 ) ) ;
    public final void ruleFalseConstraintRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:466:2: ( ( ( rule__FalseConstraintRule__Group__0 ) ) )
            // InternalDsl.g:467:2: ( ( rule__FalseConstraintRule__Group__0 ) )
            {
            // InternalDsl.g:467:2: ( ( rule__FalseConstraintRule__Group__0 ) )
            // InternalDsl.g:468:3: ( rule__FalseConstraintRule__Group__0 )
            {
             before(grammarAccess.getFalseConstraintRuleAccess().getGroup()); 
            // InternalDsl.g:469:3: ( rule__FalseConstraintRule__Group__0 )
            // InternalDsl.g:469:4: rule__FalseConstraintRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FalseConstraintRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFalseConstraintRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFalseConstraintRule"


    // $ANTLR start "entryRuleFeatureExpression"
    // InternalDsl.g:478:1: entryRuleFeatureExpression : ruleFeatureExpression EOF ;
    public final void entryRuleFeatureExpression() throws RecognitionException {
        try {
            // InternalDsl.g:479:1: ( ruleFeatureExpression EOF )
            // InternalDsl.g:480:1: ruleFeatureExpression EOF
            {
             before(grammarAccess.getFeatureExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleFeatureExpression();

            state._fsp--;

             after(grammarAccess.getFeatureExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureExpression"


    // $ANTLR start "ruleFeatureExpression"
    // InternalDsl.g:487:1: ruleFeatureExpression : ( ruleOrFeature ) ;
    public final void ruleFeatureExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:491:2: ( ( ruleOrFeature ) )
            // InternalDsl.g:492:2: ( ruleOrFeature )
            {
            // InternalDsl.g:492:2: ( ruleOrFeature )
            // InternalDsl.g:493:3: ruleOrFeature
            {
             before(grammarAccess.getFeatureExpressionAccess().getOrFeatureParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleOrFeature();

            state._fsp--;

             after(grammarAccess.getFeatureExpressionAccess().getOrFeatureParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureExpression"


    // $ANTLR start "entryRuleOrFeature"
    // InternalDsl.g:503:1: entryRuleOrFeature : ruleOrFeature EOF ;
    public final void entryRuleOrFeature() throws RecognitionException {
        try {
            // InternalDsl.g:504:1: ( ruleOrFeature EOF )
            // InternalDsl.g:505:1: ruleOrFeature EOF
            {
             before(grammarAccess.getOrFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleOrFeature();

            state._fsp--;

             after(grammarAccess.getOrFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrFeature"


    // $ANTLR start "ruleOrFeature"
    // InternalDsl.g:512:1: ruleOrFeature : ( ( rule__OrFeature__Group__0 ) ) ;
    public final void ruleOrFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:516:2: ( ( ( rule__OrFeature__Group__0 ) ) )
            // InternalDsl.g:517:2: ( ( rule__OrFeature__Group__0 ) )
            {
            // InternalDsl.g:517:2: ( ( rule__OrFeature__Group__0 ) )
            // InternalDsl.g:518:3: ( rule__OrFeature__Group__0 )
            {
             before(grammarAccess.getOrFeatureAccess().getGroup()); 
            // InternalDsl.g:519:3: ( rule__OrFeature__Group__0 )
            // InternalDsl.g:519:4: rule__OrFeature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrFeature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrFeatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrFeature"


    // $ANTLR start "entryRuleAndFeature"
    // InternalDsl.g:528:1: entryRuleAndFeature : ruleAndFeature EOF ;
    public final void entryRuleAndFeature() throws RecognitionException {
        try {
            // InternalDsl.g:529:1: ( ruleAndFeature EOF )
            // InternalDsl.g:530:1: ruleAndFeature EOF
            {
             before(grammarAccess.getAndFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleAndFeature();

            state._fsp--;

             after(grammarAccess.getAndFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndFeature"


    // $ANTLR start "ruleAndFeature"
    // InternalDsl.g:537:1: ruleAndFeature : ( ( rule__AndFeature__Group__0 ) ) ;
    public final void ruleAndFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:541:2: ( ( ( rule__AndFeature__Group__0 ) ) )
            // InternalDsl.g:542:2: ( ( rule__AndFeature__Group__0 ) )
            {
            // InternalDsl.g:542:2: ( ( rule__AndFeature__Group__0 ) )
            // InternalDsl.g:543:3: ( rule__AndFeature__Group__0 )
            {
             before(grammarAccess.getAndFeatureAccess().getGroup()); 
            // InternalDsl.g:544:3: ( rule__AndFeature__Group__0 )
            // InternalDsl.g:544:4: rule__AndFeature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndFeature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndFeatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndFeature"


    // $ANTLR start "entryRuleNotFeatureExpression"
    // InternalDsl.g:553:1: entryRuleNotFeatureExpression : ruleNotFeatureExpression EOF ;
    public final void entryRuleNotFeatureExpression() throws RecognitionException {
        try {
            // InternalDsl.g:554:1: ( ruleNotFeatureExpression EOF )
            // InternalDsl.g:555:1: ruleNotFeatureExpression EOF
            {
             before(grammarAccess.getNotFeatureExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleNotFeatureExpression();

            state._fsp--;

             after(grammarAccess.getNotFeatureExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNotFeatureExpression"


    // $ANTLR start "ruleNotFeatureExpression"
    // InternalDsl.g:562:1: ruleNotFeatureExpression : ( ( rule__NotFeatureExpression__Alternatives ) ) ;
    public final void ruleNotFeatureExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:566:2: ( ( ( rule__NotFeatureExpression__Alternatives ) ) )
            // InternalDsl.g:567:2: ( ( rule__NotFeatureExpression__Alternatives ) )
            {
            // InternalDsl.g:567:2: ( ( rule__NotFeatureExpression__Alternatives ) )
            // InternalDsl.g:568:3: ( rule__NotFeatureExpression__Alternatives )
            {
             before(grammarAccess.getNotFeatureExpressionAccess().getAlternatives()); 
            // InternalDsl.g:569:3: ( rule__NotFeatureExpression__Alternatives )
            // InternalDsl.g:569:4: rule__NotFeatureExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NotFeatureExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNotFeatureExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNotFeatureExpression"


    // $ANTLR start "entryRulePrimaryFeature"
    // InternalDsl.g:578:1: entryRulePrimaryFeature : rulePrimaryFeature EOF ;
    public final void entryRulePrimaryFeature() throws RecognitionException {
        try {
            // InternalDsl.g:579:1: ( rulePrimaryFeature EOF )
            // InternalDsl.g:580:1: rulePrimaryFeature EOF
            {
             before(grammarAccess.getPrimaryFeatureRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryFeature();

            state._fsp--;

             after(grammarAccess.getPrimaryFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryFeature"


    // $ANTLR start "rulePrimaryFeature"
    // InternalDsl.g:587:1: rulePrimaryFeature : ( ( rule__PrimaryFeature__Alternatives ) ) ;
    public final void rulePrimaryFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:591:2: ( ( ( rule__PrimaryFeature__Alternatives ) ) )
            // InternalDsl.g:592:2: ( ( rule__PrimaryFeature__Alternatives ) )
            {
            // InternalDsl.g:592:2: ( ( rule__PrimaryFeature__Alternatives ) )
            // InternalDsl.g:593:3: ( rule__PrimaryFeature__Alternatives )
            {
             before(grammarAccess.getPrimaryFeatureAccess().getAlternatives()); 
            // InternalDsl.g:594:3: ( rule__PrimaryFeature__Alternatives )
            // InternalDsl.g:594:4: rule__PrimaryFeature__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryFeature__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryFeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryFeature"


    // $ANTLR start "entryRuleConstraintExpression"
    // InternalDsl.g:603:1: entryRuleConstraintExpression : ruleConstraintExpression EOF ;
    public final void entryRuleConstraintExpression() throws RecognitionException {
        try {
            // InternalDsl.g:604:1: ( ruleConstraintExpression EOF )
            // InternalDsl.g:605:1: ruleConstraintExpression EOF
            {
             before(grammarAccess.getConstraintExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraintExpression();

            state._fsp--;

             after(grammarAccess.getConstraintExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintExpression"


    // $ANTLR start "ruleConstraintExpression"
    // InternalDsl.g:612:1: ruleConstraintExpression : ( ruleImplicationConstraint ) ;
    public final void ruleConstraintExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:616:2: ( ( ruleImplicationConstraint ) )
            // InternalDsl.g:617:2: ( ruleImplicationConstraint )
            {
            // InternalDsl.g:617:2: ( ruleImplicationConstraint )
            // InternalDsl.g:618:3: ruleImplicationConstraint
            {
             before(grammarAccess.getConstraintExpressionAccess().getImplicationConstraintParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleImplicationConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintExpressionAccess().getImplicationConstraintParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintExpression"


    // $ANTLR start "entryRuleImplicationConstraint"
    // InternalDsl.g:628:1: entryRuleImplicationConstraint : ruleImplicationConstraint EOF ;
    public final void entryRuleImplicationConstraint() throws RecognitionException {
        try {
            // InternalDsl.g:629:1: ( ruleImplicationConstraint EOF )
            // InternalDsl.g:630:1: ruleImplicationConstraint EOF
            {
             before(grammarAccess.getImplicationConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleImplicationConstraint();

            state._fsp--;

             after(grammarAccess.getImplicationConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImplicationConstraint"


    // $ANTLR start "ruleImplicationConstraint"
    // InternalDsl.g:637:1: ruleImplicationConstraint : ( ( rule__ImplicationConstraint__Group__0 ) ) ;
    public final void ruleImplicationConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:641:2: ( ( ( rule__ImplicationConstraint__Group__0 ) ) )
            // InternalDsl.g:642:2: ( ( rule__ImplicationConstraint__Group__0 ) )
            {
            // InternalDsl.g:642:2: ( ( rule__ImplicationConstraint__Group__0 ) )
            // InternalDsl.g:643:3: ( rule__ImplicationConstraint__Group__0 )
            {
             before(grammarAccess.getImplicationConstraintAccess().getGroup()); 
            // InternalDsl.g:644:3: ( rule__ImplicationConstraint__Group__0 )
            // InternalDsl.g:644:4: rule__ImplicationConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImplicationConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImplicationConstraint"


    // $ANTLR start "entryRuleOrConstraint"
    // InternalDsl.g:653:1: entryRuleOrConstraint : ruleOrConstraint EOF ;
    public final void entryRuleOrConstraint() throws RecognitionException {
        try {
            // InternalDsl.g:654:1: ( ruleOrConstraint EOF )
            // InternalDsl.g:655:1: ruleOrConstraint EOF
            {
             before(grammarAccess.getOrConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleOrConstraint();

            state._fsp--;

             after(grammarAccess.getOrConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrConstraint"


    // $ANTLR start "ruleOrConstraint"
    // InternalDsl.g:662:1: ruleOrConstraint : ( ( rule__OrConstraint__Group__0 ) ) ;
    public final void ruleOrConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:666:2: ( ( ( rule__OrConstraint__Group__0 ) ) )
            // InternalDsl.g:667:2: ( ( rule__OrConstraint__Group__0 ) )
            {
            // InternalDsl.g:667:2: ( ( rule__OrConstraint__Group__0 ) )
            // InternalDsl.g:668:3: ( rule__OrConstraint__Group__0 )
            {
             before(grammarAccess.getOrConstraintAccess().getGroup()); 
            // InternalDsl.g:669:3: ( rule__OrConstraint__Group__0 )
            // InternalDsl.g:669:4: rule__OrConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrConstraint"


    // $ANTLR start "entryRuleAndConstraint"
    // InternalDsl.g:678:1: entryRuleAndConstraint : ruleAndConstraint EOF ;
    public final void entryRuleAndConstraint() throws RecognitionException {
        try {
            // InternalDsl.g:679:1: ( ruleAndConstraint EOF )
            // InternalDsl.g:680:1: ruleAndConstraint EOF
            {
             before(grammarAccess.getAndConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleAndConstraint();

            state._fsp--;

             after(grammarAccess.getAndConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndConstraint"


    // $ANTLR start "ruleAndConstraint"
    // InternalDsl.g:687:1: ruleAndConstraint : ( ( rule__AndConstraint__Group__0 ) ) ;
    public final void ruleAndConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:691:2: ( ( ( rule__AndConstraint__Group__0 ) ) )
            // InternalDsl.g:692:2: ( ( rule__AndConstraint__Group__0 ) )
            {
            // InternalDsl.g:692:2: ( ( rule__AndConstraint__Group__0 ) )
            // InternalDsl.g:693:3: ( rule__AndConstraint__Group__0 )
            {
             before(grammarAccess.getAndConstraintAccess().getGroup()); 
            // InternalDsl.g:694:3: ( rule__AndConstraint__Group__0 )
            // InternalDsl.g:694:4: rule__AndConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndConstraint"


    // $ANTLR start "entryRuleNotConstraintExpression"
    // InternalDsl.g:703:1: entryRuleNotConstraintExpression : ruleNotConstraintExpression EOF ;
    public final void entryRuleNotConstraintExpression() throws RecognitionException {
        try {
            // InternalDsl.g:704:1: ( ruleNotConstraintExpression EOF )
            // InternalDsl.g:705:1: ruleNotConstraintExpression EOF
            {
             before(grammarAccess.getNotConstraintExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleNotConstraintExpression();

            state._fsp--;

             after(grammarAccess.getNotConstraintExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNotConstraintExpression"


    // $ANTLR start "ruleNotConstraintExpression"
    // InternalDsl.g:712:1: ruleNotConstraintExpression : ( ( rule__NotConstraintExpression__Alternatives ) ) ;
    public final void ruleNotConstraintExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:716:2: ( ( ( rule__NotConstraintExpression__Alternatives ) ) )
            // InternalDsl.g:717:2: ( ( rule__NotConstraintExpression__Alternatives ) )
            {
            // InternalDsl.g:717:2: ( ( rule__NotConstraintExpression__Alternatives ) )
            // InternalDsl.g:718:3: ( rule__NotConstraintExpression__Alternatives )
            {
             before(grammarAccess.getNotConstraintExpressionAccess().getAlternatives()); 
            // InternalDsl.g:719:3: ( rule__NotConstraintExpression__Alternatives )
            // InternalDsl.g:719:4: rule__NotConstraintExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NotConstraintExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNotConstraintExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNotConstraintExpression"


    // $ANTLR start "entryRulePrimaryConstraint"
    // InternalDsl.g:728:1: entryRulePrimaryConstraint : rulePrimaryConstraint EOF ;
    public final void entryRulePrimaryConstraint() throws RecognitionException {
        try {
            // InternalDsl.g:729:1: ( rulePrimaryConstraint EOF )
            // InternalDsl.g:730:1: rulePrimaryConstraint EOF
            {
             before(grammarAccess.getPrimaryConstraintRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryConstraint();

            state._fsp--;

             after(grammarAccess.getPrimaryConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryConstraint"


    // $ANTLR start "rulePrimaryConstraint"
    // InternalDsl.g:737:1: rulePrimaryConstraint : ( ( rule__PrimaryConstraint__Alternatives ) ) ;
    public final void rulePrimaryConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:741:2: ( ( ( rule__PrimaryConstraint__Alternatives ) ) )
            // InternalDsl.g:742:2: ( ( rule__PrimaryConstraint__Alternatives ) )
            {
            // InternalDsl.g:742:2: ( ( rule__PrimaryConstraint__Alternatives ) )
            // InternalDsl.g:743:3: ( rule__PrimaryConstraint__Alternatives )
            {
             before(grammarAccess.getPrimaryConstraintAccess().getAlternatives()); 
            // InternalDsl.g:744:3: ( rule__PrimaryConstraint__Alternatives )
            // InternalDsl.g:744:4: rule__PrimaryConstraint__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryConstraint__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryConstraintAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryConstraint"


    // $ANTLR start "ruleActionEnum"
    // InternalDsl.g:753:1: ruleActionEnum : ( ( rule__ActionEnum__Alternatives ) ) ;
    public final void ruleActionEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:757:1: ( ( ( rule__ActionEnum__Alternatives ) ) )
            // InternalDsl.g:758:2: ( ( rule__ActionEnum__Alternatives ) )
            {
            // InternalDsl.g:758:2: ( ( rule__ActionEnum__Alternatives ) )
            // InternalDsl.g:759:3: ( rule__ActionEnum__Alternatives )
            {
             before(grammarAccess.getActionEnumAccess().getAlternatives()); 
            // InternalDsl.g:760:3: ( rule__ActionEnum__Alternatives )
            // InternalDsl.g:760:4: rule__ActionEnum__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ActionEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionEnumAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActionEnum"


    // $ANTLR start "ruleFeatureTypeEnum"
    // InternalDsl.g:769:1: ruleFeatureTypeEnum : ( ( rule__FeatureTypeEnum__Alternatives ) ) ;
    public final void ruleFeatureTypeEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:773:1: ( ( ( rule__FeatureTypeEnum__Alternatives ) ) )
            // InternalDsl.g:774:2: ( ( rule__FeatureTypeEnum__Alternatives ) )
            {
            // InternalDsl.g:774:2: ( ( rule__FeatureTypeEnum__Alternatives ) )
            // InternalDsl.g:775:3: ( rule__FeatureTypeEnum__Alternatives )
            {
             before(grammarAccess.getFeatureTypeEnumAccess().getAlternatives()); 
            // InternalDsl.g:776:3: ( rule__FeatureTypeEnum__Alternatives )
            // InternalDsl.g:776:4: rule__FeatureTypeEnum__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FeatureTypeEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFeatureTypeEnumAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureTypeEnum"


    // $ANTLR start "ruleFeatureNameEnum"
    // InternalDsl.g:785:1: ruleFeatureNameEnum : ( ( rule__FeatureNameEnum__Alternatives ) ) ;
    public final void ruleFeatureNameEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:789:1: ( ( ( rule__FeatureNameEnum__Alternatives ) ) )
            // InternalDsl.g:790:2: ( ( rule__FeatureNameEnum__Alternatives ) )
            {
            // InternalDsl.g:790:2: ( ( rule__FeatureNameEnum__Alternatives ) )
            // InternalDsl.g:791:3: ( rule__FeatureNameEnum__Alternatives )
            {
             before(grammarAccess.getFeatureNameEnumAccess().getAlternatives()); 
            // InternalDsl.g:792:3: ( rule__FeatureNameEnum__Alternatives )
            // InternalDsl.g:792:4: rule__FeatureNameEnum__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FeatureNameEnum__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFeatureNameEnumAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureNameEnum"


    // $ANTLR start "rule__ConstraintRule__Alternatives"
    // InternalDsl.g:800:1: rule__ConstraintRule__Alternatives : ( ( ruleTrueConstraintRule ) | ( ruleFalseConstraintRule ) | ( ruleContainsCompartmentConstrainRule ) | ( ruleIsTargetConstraintRule ) | ( ruleIsTargetTypeConstraintRule ) | ( ruleIsSourceTypeConstraintRule ) | ( ruleIsParentConstraintRule ) | ( ruleSourceEqualsTargetConstraintRule ) | ( ruleSourceEqualsTargetTypeConstraintRule ) | ( ruleInCompartmentConstraintRule ) );
    public final void rule__ConstraintRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:804:1: ( ( ruleTrueConstraintRule ) | ( ruleFalseConstraintRule ) | ( ruleContainsCompartmentConstrainRule ) | ( ruleIsTargetConstraintRule ) | ( ruleIsTargetTypeConstraintRule ) | ( ruleIsSourceTypeConstraintRule ) | ( ruleIsParentConstraintRule ) | ( ruleSourceEqualsTargetConstraintRule ) | ( ruleSourceEqualsTargetTypeConstraintRule ) | ( ruleInCompartmentConstraintRule ) )
            int alt2=10;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt2=1;
                }
                break;
            case 89:
                {
                alt2=2;
                }
                break;
            case 80:
                {
                alt2=3;
                }
                break;
            case 84:
                {
                alt2=4;
                }
                break;
            case 81:
                {
                alt2=5;
                }
                break;
            case 83:
                {
                alt2=6;
                }
                break;
            case 82:
                {
                alt2=7;
                }
                break;
            case 86:
                {
                alt2=8;
                }
                break;
            case 87:
                {
                alt2=9;
                }
                break;
            case 85:
                {
                alt2=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalDsl.g:805:2: ( ruleTrueConstraintRule )
                    {
                    // InternalDsl.g:805:2: ( ruleTrueConstraintRule )
                    // InternalDsl.g:806:3: ruleTrueConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getTrueConstraintRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTrueConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getTrueConstraintRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:811:2: ( ruleFalseConstraintRule )
                    {
                    // InternalDsl.g:811:2: ( ruleFalseConstraintRule )
                    // InternalDsl.g:812:3: ruleFalseConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getFalseConstraintRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFalseConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getFalseConstraintRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:817:2: ( ruleContainsCompartmentConstrainRule )
                    {
                    // InternalDsl.g:817:2: ( ruleContainsCompartmentConstrainRule )
                    // InternalDsl.g:818:3: ruleContainsCompartmentConstrainRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getContainsCompartmentConstrainRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleContainsCompartmentConstrainRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getContainsCompartmentConstrainRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:823:2: ( ruleIsTargetConstraintRule )
                    {
                    // InternalDsl.g:823:2: ( ruleIsTargetConstraintRule )
                    // InternalDsl.g:824:3: ruleIsTargetConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getIsTargetConstraintRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleIsTargetConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getIsTargetConstraintRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:829:2: ( ruleIsTargetTypeConstraintRule )
                    {
                    // InternalDsl.g:829:2: ( ruleIsTargetTypeConstraintRule )
                    // InternalDsl.g:830:3: ruleIsTargetTypeConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getIsTargetTypeConstraintRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleIsTargetTypeConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getIsTargetTypeConstraintRuleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:835:2: ( ruleIsSourceTypeConstraintRule )
                    {
                    // InternalDsl.g:835:2: ( ruleIsSourceTypeConstraintRule )
                    // InternalDsl.g:836:3: ruleIsSourceTypeConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getIsSourceTypeConstraintRuleParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleIsSourceTypeConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getIsSourceTypeConstraintRuleParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:841:2: ( ruleIsParentConstraintRule )
                    {
                    // InternalDsl.g:841:2: ( ruleIsParentConstraintRule )
                    // InternalDsl.g:842:3: ruleIsParentConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getIsParentConstraintRuleParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleIsParentConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getIsParentConstraintRuleParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:847:2: ( ruleSourceEqualsTargetConstraintRule )
                    {
                    // InternalDsl.g:847:2: ( ruleSourceEqualsTargetConstraintRule )
                    // InternalDsl.g:848:3: ruleSourceEqualsTargetConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getSourceEqualsTargetConstraintRuleParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleSourceEqualsTargetConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getSourceEqualsTargetConstraintRuleParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:853:2: ( ruleSourceEqualsTargetTypeConstraintRule )
                    {
                    // InternalDsl.g:853:2: ( ruleSourceEqualsTargetTypeConstraintRule )
                    // InternalDsl.g:854:3: ruleSourceEqualsTargetTypeConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getSourceEqualsTargetTypeConstraintRuleParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleSourceEqualsTargetTypeConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getSourceEqualsTargetTypeConstraintRuleParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:859:2: ( ruleInCompartmentConstraintRule )
                    {
                    // InternalDsl.g:859:2: ( ruleInCompartmentConstraintRule )
                    // InternalDsl.g:860:3: ruleInCompartmentConstraintRule
                    {
                     before(grammarAccess.getConstraintRuleAccess().getInCompartmentConstraintRuleParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleInCompartmentConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getConstraintRuleAccess().getInCompartmentConstraintRuleParserRuleCall_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRule__Alternatives"


    // $ANTLR start "rule__FeatureRule__Alternatives"
    // InternalDsl.g:869:1: rule__FeatureRule__Alternatives : ( ( ruleIsFeature ) | ( ruleTrueFeatureRule ) | ( ruleFalseFeatureRule ) );
    public final void rule__FeatureRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:873:1: ( ( ruleIsFeature ) | ( ruleTrueFeatureRule ) | ( ruleFalseFeatureRule ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
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
                {
                alt3=1;
                }
                break;
            case 88:
                {
                alt3=2;
                }
                break;
            case 89:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalDsl.g:874:2: ( ruleIsFeature )
                    {
                    // InternalDsl.g:874:2: ( ruleIsFeature )
                    // InternalDsl.g:875:3: ruleIsFeature
                    {
                     before(grammarAccess.getFeatureRuleAccess().getIsFeatureParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIsFeature();

                    state._fsp--;

                     after(grammarAccess.getFeatureRuleAccess().getIsFeatureParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:880:2: ( ruleTrueFeatureRule )
                    {
                    // InternalDsl.g:880:2: ( ruleTrueFeatureRule )
                    // InternalDsl.g:881:3: ruleTrueFeatureRule
                    {
                     before(grammarAccess.getFeatureRuleAccess().getTrueFeatureRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTrueFeatureRule();

                    state._fsp--;

                     after(grammarAccess.getFeatureRuleAccess().getTrueFeatureRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:886:2: ( ruleFalseFeatureRule )
                    {
                    // InternalDsl.g:886:2: ( ruleFalseFeatureRule )
                    // InternalDsl.g:887:3: ruleFalseFeatureRule
                    {
                     before(grammarAccess.getFeatureRuleAccess().getFalseFeatureRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFalseFeatureRule();

                    state._fsp--;

                     after(grammarAccess.getFeatureRuleAccess().getFalseFeatureRuleParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureRule__Alternatives"


    // $ANTLR start "rule__NotFeatureExpression__Alternatives"
    // InternalDsl.g:896:1: rule__NotFeatureExpression__Alternatives : ( ( rulePrimaryFeature ) | ( ( rule__NotFeatureExpression__Group_1__0 ) ) );
    public final void rule__NotFeatureExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:900:1: ( ( rulePrimaryFeature ) | ( ( rule__NotFeatureExpression__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=39 && LA4_0<=76)||(LA4_0>=88 && LA4_0<=89)) ) {
                alt4=1;
            }
            else if ( (LA4_0==92) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalDsl.g:901:2: ( rulePrimaryFeature )
                    {
                    // InternalDsl.g:901:2: ( rulePrimaryFeature )
                    // InternalDsl.g:902:3: rulePrimaryFeature
                    {
                     before(grammarAccess.getNotFeatureExpressionAccess().getPrimaryFeatureParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePrimaryFeature();

                    state._fsp--;

                     after(grammarAccess.getNotFeatureExpressionAccess().getPrimaryFeatureParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:907:2: ( ( rule__NotFeatureExpression__Group_1__0 ) )
                    {
                    // InternalDsl.g:907:2: ( ( rule__NotFeatureExpression__Group_1__0 ) )
                    // InternalDsl.g:908:3: ( rule__NotFeatureExpression__Group_1__0 )
                    {
                     before(grammarAccess.getNotFeatureExpressionAccess().getGroup_1()); 
                    // InternalDsl.g:909:3: ( rule__NotFeatureExpression__Group_1__0 )
                    // InternalDsl.g:909:4: rule__NotFeatureExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NotFeatureExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNotFeatureExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Alternatives"


    // $ANTLR start "rule__PrimaryFeature__Alternatives"
    // InternalDsl.g:917:1: rule__PrimaryFeature__Alternatives : ( ( ruleFeatureRule ) | ( ( rule__PrimaryFeature__Group_1__0 ) ) );
    public final void rule__PrimaryFeature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:921:1: ( ( ruleFeatureRule ) | ( ( rule__PrimaryFeature__Group_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=39 && LA5_0<=75)||(LA5_0>=88 && LA5_0<=89)) ) {
                alt5=1;
            }
            else if ( (LA5_0==76) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalDsl.g:922:2: ( ruleFeatureRule )
                    {
                    // InternalDsl.g:922:2: ( ruleFeatureRule )
                    // InternalDsl.g:923:3: ruleFeatureRule
                    {
                     before(grammarAccess.getPrimaryFeatureAccess().getFeatureRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFeatureRule();

                    state._fsp--;

                     after(grammarAccess.getPrimaryFeatureAccess().getFeatureRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:928:2: ( ( rule__PrimaryFeature__Group_1__0 ) )
                    {
                    // InternalDsl.g:928:2: ( ( rule__PrimaryFeature__Group_1__0 ) )
                    // InternalDsl.g:929:3: ( rule__PrimaryFeature__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryFeatureAccess().getGroup_1()); 
                    // InternalDsl.g:930:3: ( rule__PrimaryFeature__Group_1__0 )
                    // InternalDsl.g:930:4: rule__PrimaryFeature__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryFeature__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryFeatureAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Alternatives"


    // $ANTLR start "rule__NotConstraintExpression__Alternatives"
    // InternalDsl.g:938:1: rule__NotConstraintExpression__Alternatives : ( ( rulePrimaryConstraint ) | ( ( rule__NotConstraintExpression__Group_1__0 ) ) );
    public final void rule__NotConstraintExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:942:1: ( ( rulePrimaryConstraint ) | ( ( rule__NotConstraintExpression__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==76||(LA6_0>=80 && LA6_0<=89)) ) {
                alt6=1;
            }
            else if ( (LA6_0==92) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalDsl.g:943:2: ( rulePrimaryConstraint )
                    {
                    // InternalDsl.g:943:2: ( rulePrimaryConstraint )
                    // InternalDsl.g:944:3: rulePrimaryConstraint
                    {
                     before(grammarAccess.getNotConstraintExpressionAccess().getPrimaryConstraintParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePrimaryConstraint();

                    state._fsp--;

                     after(grammarAccess.getNotConstraintExpressionAccess().getPrimaryConstraintParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:949:2: ( ( rule__NotConstraintExpression__Group_1__0 ) )
                    {
                    // InternalDsl.g:949:2: ( ( rule__NotConstraintExpression__Group_1__0 ) )
                    // InternalDsl.g:950:3: ( rule__NotConstraintExpression__Group_1__0 )
                    {
                     before(grammarAccess.getNotConstraintExpressionAccess().getGroup_1()); 
                    // InternalDsl.g:951:3: ( rule__NotConstraintExpression__Group_1__0 )
                    // InternalDsl.g:951:4: rule__NotConstraintExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NotConstraintExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNotConstraintExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Alternatives"


    // $ANTLR start "rule__PrimaryConstraint__Alternatives"
    // InternalDsl.g:959:1: rule__PrimaryConstraint__Alternatives : ( ( ruleConstraintRule ) | ( ( rule__PrimaryConstraint__Group_1__0 ) ) );
    public final void rule__PrimaryConstraint__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:963:1: ( ( ruleConstraintRule ) | ( ( rule__PrimaryConstraint__Group_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=80 && LA7_0<=89)) ) {
                alt7=1;
            }
            else if ( (LA7_0==76) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDsl.g:964:2: ( ruleConstraintRule )
                    {
                    // InternalDsl.g:964:2: ( ruleConstraintRule )
                    // InternalDsl.g:965:3: ruleConstraintRule
                    {
                     before(grammarAccess.getPrimaryConstraintAccess().getConstraintRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleConstraintRule();

                    state._fsp--;

                     after(grammarAccess.getPrimaryConstraintAccess().getConstraintRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:970:2: ( ( rule__PrimaryConstraint__Group_1__0 ) )
                    {
                    // InternalDsl.g:970:2: ( ( rule__PrimaryConstraint__Group_1__0 ) )
                    // InternalDsl.g:971:3: ( rule__PrimaryConstraint__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryConstraintAccess().getGroup_1()); 
                    // InternalDsl.g:972:3: ( rule__PrimaryConstraint__Group_1__0 )
                    // InternalDsl.g:972:4: rule__PrimaryConstraint__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryConstraint__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryConstraintAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Alternatives"


    // $ANTLR start "rule__ActionEnum__Alternatives"
    // InternalDsl.g:980:1: rule__ActionEnum__Alternatives : ( ( ( 'Add' ) ) | ( ( 'Reconnect' ) ) | ( ( 'Create' ) ) | ( ( 'Start' ) ) | ( ( 'Execute' ) ) | ( ( 'Direct_Edit' ) ) | ( ( 'Add_Property' ) ) | ( ( 'Create_Attribute' ) ) | ( ( 'Create_Operation' ) ) | ( ( 'Create_Property' ) ) );
    public final void rule__ActionEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:984:1: ( ( ( 'Add' ) ) | ( ( 'Reconnect' ) ) | ( ( 'Create' ) ) | ( ( 'Start' ) ) | ( ( 'Execute' ) ) | ( ( 'Direct_Edit' ) ) | ( ( 'Add_Property' ) ) | ( ( 'Create_Attribute' ) ) | ( ( 'Create_Operation' ) ) | ( ( 'Create_Property' ) ) )
            int alt8=10;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt8=1;
                }
                break;
            case 12:
                {
                alt8=2;
                }
                break;
            case 13:
                {
                alt8=3;
                }
                break;
            case 14:
                {
                alt8=4;
                }
                break;
            case 15:
                {
                alt8=5;
                }
                break;
            case 16:
                {
                alt8=6;
                }
                break;
            case 17:
                {
                alt8=7;
                }
                break;
            case 18:
                {
                alt8=8;
                }
                break;
            case 19:
                {
                alt8=9;
                }
                break;
            case 20:
                {
                alt8=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDsl.g:985:2: ( ( 'Add' ) )
                    {
                    // InternalDsl.g:985:2: ( ( 'Add' ) )
                    // InternalDsl.g:986:3: ( 'Add' )
                    {
                     before(grammarAccess.getActionEnumAccess().getAddEnumLiteralDeclaration_0()); 
                    // InternalDsl.g:987:3: ( 'Add' )
                    // InternalDsl.g:987:4: 'Add'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getAddEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:991:2: ( ( 'Reconnect' ) )
                    {
                    // InternalDsl.g:991:2: ( ( 'Reconnect' ) )
                    // InternalDsl.g:992:3: ( 'Reconnect' )
                    {
                     before(grammarAccess.getActionEnumAccess().getReconnectEnumLiteralDeclaration_1()); 
                    // InternalDsl.g:993:3: ( 'Reconnect' )
                    // InternalDsl.g:993:4: 'Reconnect'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getReconnectEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:997:2: ( ( 'Create' ) )
                    {
                    // InternalDsl.g:997:2: ( ( 'Create' ) )
                    // InternalDsl.g:998:3: ( 'Create' )
                    {
                     before(grammarAccess.getActionEnumAccess().getCreateEnumLiteralDeclaration_2()); 
                    // InternalDsl.g:999:3: ( 'Create' )
                    // InternalDsl.g:999:4: 'Create'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getCreateEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:1003:2: ( ( 'Start' ) )
                    {
                    // InternalDsl.g:1003:2: ( ( 'Start' ) )
                    // InternalDsl.g:1004:3: ( 'Start' )
                    {
                     before(grammarAccess.getActionEnumAccess().getStartEnumLiteralDeclaration_3()); 
                    // InternalDsl.g:1005:3: ( 'Start' )
                    // InternalDsl.g:1005:4: 'Start'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getStartEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:1009:2: ( ( 'Execute' ) )
                    {
                    // InternalDsl.g:1009:2: ( ( 'Execute' ) )
                    // InternalDsl.g:1010:3: ( 'Execute' )
                    {
                     before(grammarAccess.getActionEnumAccess().getExecuteEnumLiteralDeclaration_4()); 
                    // InternalDsl.g:1011:3: ( 'Execute' )
                    // InternalDsl.g:1011:4: 'Execute'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getExecuteEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:1015:2: ( ( 'Direct_Edit' ) )
                    {
                    // InternalDsl.g:1015:2: ( ( 'Direct_Edit' ) )
                    // InternalDsl.g:1016:3: ( 'Direct_Edit' )
                    {
                     before(grammarAccess.getActionEnumAccess().getDirect_EditEnumLiteralDeclaration_5()); 
                    // InternalDsl.g:1017:3: ( 'Direct_Edit' )
                    // InternalDsl.g:1017:4: 'Direct_Edit'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getDirect_EditEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:1021:2: ( ( 'Add_Property' ) )
                    {
                    // InternalDsl.g:1021:2: ( ( 'Add_Property' ) )
                    // InternalDsl.g:1022:3: ( 'Add_Property' )
                    {
                     before(grammarAccess.getActionEnumAccess().getAdd_PropertyEnumLiteralDeclaration_6()); 
                    // InternalDsl.g:1023:3: ( 'Add_Property' )
                    // InternalDsl.g:1023:4: 'Add_Property'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getAdd_PropertyEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:1027:2: ( ( 'Create_Attribute' ) )
                    {
                    // InternalDsl.g:1027:2: ( ( 'Create_Attribute' ) )
                    // InternalDsl.g:1028:3: ( 'Create_Attribute' )
                    {
                     before(grammarAccess.getActionEnumAccess().getCreate_AttributeEnumLiteralDeclaration_7()); 
                    // InternalDsl.g:1029:3: ( 'Create_Attribute' )
                    // InternalDsl.g:1029:4: 'Create_Attribute'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getCreate_AttributeEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:1033:2: ( ( 'Create_Operation' ) )
                    {
                    // InternalDsl.g:1033:2: ( ( 'Create_Operation' ) )
                    // InternalDsl.g:1034:3: ( 'Create_Operation' )
                    {
                     before(grammarAccess.getActionEnumAccess().getCreate_OperationEnumLiteralDeclaration_8()); 
                    // InternalDsl.g:1035:3: ( 'Create_Operation' )
                    // InternalDsl.g:1035:4: 'Create_Operation'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getCreate_OperationEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:1039:2: ( ( 'Create_Property' ) )
                    {
                    // InternalDsl.g:1039:2: ( ( 'Create_Property' ) )
                    // InternalDsl.g:1040:3: ( 'Create_Property' )
                    {
                     before(grammarAccess.getActionEnumAccess().getCreate_PropertyEnumLiteralDeclaration_9()); 
                    // InternalDsl.g:1041:3: ( 'Create_Property' )
                    // InternalDsl.g:1041:4: 'Create_Property'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionEnumAccess().getCreate_PropertyEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEnum__Alternatives"


    // $ANTLR start "rule__FeatureTypeEnum__Alternatives"
    // InternalDsl.g:1049:1: rule__FeatureTypeEnum__Alternatives : ( ( ( 'Acyclic' ) ) | ( ( 'CompartmentType' ) ) | ( ( 'Cyclic' ) ) | ( ( 'DataType' ) ) | ( ( 'Fulfillment' ) ) | ( ( 'Inheritance' ) ) | ( ( 'Group' ) ) | ( ( 'Reflexive' ) ) | ( ( 'Relationship' ) ) | ( ( 'RelationshipExclusion' ) ) | ( ( 'RelationshipImplication' ) ) | ( ( 'RoleType' ) ) | ( ( 'RoleEquivalence' ) ) | ( ( 'RoleGroup' ) ) | ( ( 'RoleImplication' ) ) | ( ( 'RoleProhibition' ) ) | ( ( 'Irreflexive' ) ) | ( ( 'NaturalType' ) ) );
    public final void rule__FeatureTypeEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1053:1: ( ( ( 'Acyclic' ) ) | ( ( 'CompartmentType' ) ) | ( ( 'Cyclic' ) ) | ( ( 'DataType' ) ) | ( ( 'Fulfillment' ) ) | ( ( 'Inheritance' ) ) | ( ( 'Group' ) ) | ( ( 'Reflexive' ) ) | ( ( 'Relationship' ) ) | ( ( 'RelationshipExclusion' ) ) | ( ( 'RelationshipImplication' ) ) | ( ( 'RoleType' ) ) | ( ( 'RoleEquivalence' ) ) | ( ( 'RoleGroup' ) ) | ( ( 'RoleImplication' ) ) | ( ( 'RoleProhibition' ) ) | ( ( 'Irreflexive' ) ) | ( ( 'NaturalType' ) ) )
            int alt9=18;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt9=1;
                }
                break;
            case 22:
                {
                alt9=2;
                }
                break;
            case 23:
                {
                alt9=3;
                }
                break;
            case 24:
                {
                alt9=4;
                }
                break;
            case 25:
                {
                alt9=5;
                }
                break;
            case 26:
                {
                alt9=6;
                }
                break;
            case 27:
                {
                alt9=7;
                }
                break;
            case 28:
                {
                alt9=8;
                }
                break;
            case 29:
                {
                alt9=9;
                }
                break;
            case 30:
                {
                alt9=10;
                }
                break;
            case 31:
                {
                alt9=11;
                }
                break;
            case 32:
                {
                alt9=12;
                }
                break;
            case 33:
                {
                alt9=13;
                }
                break;
            case 34:
                {
                alt9=14;
                }
                break;
            case 35:
                {
                alt9=15;
                }
                break;
            case 36:
                {
                alt9=16;
                }
                break;
            case 37:
                {
                alt9=17;
                }
                break;
            case 38:
                {
                alt9=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalDsl.g:1054:2: ( ( 'Acyclic' ) )
                    {
                    // InternalDsl.g:1054:2: ( ( 'Acyclic' ) )
                    // InternalDsl.g:1055:3: ( 'Acyclic' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getAcyclicEnumLiteralDeclaration_0()); 
                    // InternalDsl.g:1056:3: ( 'Acyclic' )
                    // InternalDsl.g:1056:4: 'Acyclic'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getAcyclicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:1060:2: ( ( 'CompartmentType' ) )
                    {
                    // InternalDsl.g:1060:2: ( ( 'CompartmentType' ) )
                    // InternalDsl.g:1061:3: ( 'CompartmentType' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getCompartmentTypeEnumLiteralDeclaration_1()); 
                    // InternalDsl.g:1062:3: ( 'CompartmentType' )
                    // InternalDsl.g:1062:4: 'CompartmentType'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getCompartmentTypeEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:1066:2: ( ( 'Cyclic' ) )
                    {
                    // InternalDsl.g:1066:2: ( ( 'Cyclic' ) )
                    // InternalDsl.g:1067:3: ( 'Cyclic' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getCyclicEnumLiteralDeclaration_2()); 
                    // InternalDsl.g:1068:3: ( 'Cyclic' )
                    // InternalDsl.g:1068:4: 'Cyclic'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getCyclicEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:1072:2: ( ( 'DataType' ) )
                    {
                    // InternalDsl.g:1072:2: ( ( 'DataType' ) )
                    // InternalDsl.g:1073:3: ( 'DataType' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getDataTypeEnumLiteralDeclaration_3()); 
                    // InternalDsl.g:1074:3: ( 'DataType' )
                    // InternalDsl.g:1074:4: 'DataType'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getDataTypeEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:1078:2: ( ( 'Fulfillment' ) )
                    {
                    // InternalDsl.g:1078:2: ( ( 'Fulfillment' ) )
                    // InternalDsl.g:1079:3: ( 'Fulfillment' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getFulfillmentEnumLiteralDeclaration_4()); 
                    // InternalDsl.g:1080:3: ( 'Fulfillment' )
                    // InternalDsl.g:1080:4: 'Fulfillment'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getFulfillmentEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:1084:2: ( ( 'Inheritance' ) )
                    {
                    // InternalDsl.g:1084:2: ( ( 'Inheritance' ) )
                    // InternalDsl.g:1085:3: ( 'Inheritance' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getInheritanceEnumLiteralDeclaration_5()); 
                    // InternalDsl.g:1086:3: ( 'Inheritance' )
                    // InternalDsl.g:1086:4: 'Inheritance'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getInheritanceEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:1090:2: ( ( 'Group' ) )
                    {
                    // InternalDsl.g:1090:2: ( ( 'Group' ) )
                    // InternalDsl.g:1091:3: ( 'Group' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getGroupEnumLiteralDeclaration_6()); 
                    // InternalDsl.g:1092:3: ( 'Group' )
                    // InternalDsl.g:1092:4: 'Group'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getGroupEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:1096:2: ( ( 'Reflexive' ) )
                    {
                    // InternalDsl.g:1096:2: ( ( 'Reflexive' ) )
                    // InternalDsl.g:1097:3: ( 'Reflexive' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getReflexiveEnumLiteralDeclaration_7()); 
                    // InternalDsl.g:1098:3: ( 'Reflexive' )
                    // InternalDsl.g:1098:4: 'Reflexive'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getReflexiveEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:1102:2: ( ( 'Relationship' ) )
                    {
                    // InternalDsl.g:1102:2: ( ( 'Relationship' ) )
                    // InternalDsl.g:1103:3: ( 'Relationship' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRelationshipEnumLiteralDeclaration_8()); 
                    // InternalDsl.g:1104:3: ( 'Relationship' )
                    // InternalDsl.g:1104:4: 'Relationship'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRelationshipEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:1108:2: ( ( 'RelationshipExclusion' ) )
                    {
                    // InternalDsl.g:1108:2: ( ( 'RelationshipExclusion' ) )
                    // InternalDsl.g:1109:3: ( 'RelationshipExclusion' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRelationshipExclusionEnumLiteralDeclaration_9()); 
                    // InternalDsl.g:1110:3: ( 'RelationshipExclusion' )
                    // InternalDsl.g:1110:4: 'RelationshipExclusion'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRelationshipExclusionEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDsl.g:1114:2: ( ( 'RelationshipImplication' ) )
                    {
                    // InternalDsl.g:1114:2: ( ( 'RelationshipImplication' ) )
                    // InternalDsl.g:1115:3: ( 'RelationshipImplication' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRelationshipImplicationEnumLiteralDeclaration_10()); 
                    // InternalDsl.g:1116:3: ( 'RelationshipImplication' )
                    // InternalDsl.g:1116:4: 'RelationshipImplication'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRelationshipImplicationEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDsl.g:1120:2: ( ( 'RoleType' ) )
                    {
                    // InternalDsl.g:1120:2: ( ( 'RoleType' ) )
                    // InternalDsl.g:1121:3: ( 'RoleType' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRoleTypeEnumLiteralDeclaration_11()); 
                    // InternalDsl.g:1122:3: ( 'RoleType' )
                    // InternalDsl.g:1122:4: 'RoleType'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRoleTypeEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDsl.g:1126:2: ( ( 'RoleEquivalence' ) )
                    {
                    // InternalDsl.g:1126:2: ( ( 'RoleEquivalence' ) )
                    // InternalDsl.g:1127:3: ( 'RoleEquivalence' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRoleEquivalenceEnumLiteralDeclaration_12()); 
                    // InternalDsl.g:1128:3: ( 'RoleEquivalence' )
                    // InternalDsl.g:1128:4: 'RoleEquivalence'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRoleEquivalenceEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDsl.g:1132:2: ( ( 'RoleGroup' ) )
                    {
                    // InternalDsl.g:1132:2: ( ( 'RoleGroup' ) )
                    // InternalDsl.g:1133:3: ( 'RoleGroup' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRoleGroupEnumLiteralDeclaration_13()); 
                    // InternalDsl.g:1134:3: ( 'RoleGroup' )
                    // InternalDsl.g:1134:4: 'RoleGroup'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRoleGroupEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDsl.g:1138:2: ( ( 'RoleImplication' ) )
                    {
                    // InternalDsl.g:1138:2: ( ( 'RoleImplication' ) )
                    // InternalDsl.g:1139:3: ( 'RoleImplication' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRoleImplicationEnumLiteralDeclaration_14()); 
                    // InternalDsl.g:1140:3: ( 'RoleImplication' )
                    // InternalDsl.g:1140:4: 'RoleImplication'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRoleImplicationEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDsl.g:1144:2: ( ( 'RoleProhibition' ) )
                    {
                    // InternalDsl.g:1144:2: ( ( 'RoleProhibition' ) )
                    // InternalDsl.g:1145:3: ( 'RoleProhibition' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getRoleProhibitionEnumLiteralDeclaration_15()); 
                    // InternalDsl.g:1146:3: ( 'RoleProhibition' )
                    // InternalDsl.g:1146:4: 'RoleProhibition'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getRoleProhibitionEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDsl.g:1150:2: ( ( 'Irreflexive' ) )
                    {
                    // InternalDsl.g:1150:2: ( ( 'Irreflexive' ) )
                    // InternalDsl.g:1151:3: ( 'Irreflexive' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getIrreflexiveEnumLiteralDeclaration_16()); 
                    // InternalDsl.g:1152:3: ( 'Irreflexive' )
                    // InternalDsl.g:1152:4: 'Irreflexive'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getIrreflexiveEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDsl.g:1156:2: ( ( 'NaturalType' ) )
                    {
                    // InternalDsl.g:1156:2: ( ( 'NaturalType' ) )
                    // InternalDsl.g:1157:3: ( 'NaturalType' )
                    {
                     before(grammarAccess.getFeatureTypeEnumAccess().getNaturalTypeEnumLiteralDeclaration_17()); 
                    // InternalDsl.g:1158:3: ( 'NaturalType' )
                    // InternalDsl.g:1158:4: 'NaturalType'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureTypeEnumAccess().getNaturalTypeEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureTypeEnum__Alternatives"


    // $ANTLR start "rule__FeatureNameEnum__Alternatives"
    // InternalDsl.g:1166:1: rule__FeatureNameEnum__Alternatives : ( ( ( 'Compartment_Behavior' ) ) | ( ( 'Compartment_Inheritance' ) ) | ( ( 'Compartment_Properties' ) ) | ( ( 'Compartment_Structure' ) ) | ( ( 'Compartment_Types' ) ) | ( ( 'Contains_Compartments' ) ) | ( ( 'Compartments' ) ) | ( ( 'Data_Type_Inheritance' ) ) | ( ( 'Data_Types' ) ) | ( ( 'Dates' ) ) | ( ( 'Dependent' ) ) | ( ( 'Group_Constraints' ) ) | ( ( 'Inter_Relationship_Constraints' ) ) | ( ( 'Intra_Relationship_Constraints' ) ) | ( ( 'Naturals' ) ) | ( ( 'Occurrence_Constraints' ) ) | ( ( 'On_Compartments' ) ) | ( ( 'On_Relationships' ) ) | ( ( 'Parthood_Constraints' ) ) | ( ( 'Participants' ) ) | ( ( 'Playable' ) ) | ( ( 'Playable_by_Defining_Compartment' ) ) | ( ( 'Players' ) ) | ( ( 'Relationship_Cardinality' ) ) | ( ( 'Relationship_Constraints' ) ) | ( ( 'Relationships' ) ) | ( ( 'RML_Feature_Model' ) ) | ( ( 'Role_Behavior' ) ) | ( ( 'Role_Constraints' ) ) | ( ( 'Role_Equivalence' ) ) | ( ( 'Role_Implication' ) ) | ( ( 'Role_Inheritance' ) ) | ( ( 'Role_Prohibition' ) ) | ( ( 'Role_Properties' ) ) | ( ( 'Role_Structure' ) ) | ( ( 'Role_Types' ) ) | ( ( 'Roles' ) ) );
    public final void rule__FeatureNameEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1170:1: ( ( ( 'Compartment_Behavior' ) ) | ( ( 'Compartment_Inheritance' ) ) | ( ( 'Compartment_Properties' ) ) | ( ( 'Compartment_Structure' ) ) | ( ( 'Compartment_Types' ) ) | ( ( 'Contains_Compartments' ) ) | ( ( 'Compartments' ) ) | ( ( 'Data_Type_Inheritance' ) ) | ( ( 'Data_Types' ) ) | ( ( 'Dates' ) ) | ( ( 'Dependent' ) ) | ( ( 'Group_Constraints' ) ) | ( ( 'Inter_Relationship_Constraints' ) ) | ( ( 'Intra_Relationship_Constraints' ) ) | ( ( 'Naturals' ) ) | ( ( 'Occurrence_Constraints' ) ) | ( ( 'On_Compartments' ) ) | ( ( 'On_Relationships' ) ) | ( ( 'Parthood_Constraints' ) ) | ( ( 'Participants' ) ) | ( ( 'Playable' ) ) | ( ( 'Playable_by_Defining_Compartment' ) ) | ( ( 'Players' ) ) | ( ( 'Relationship_Cardinality' ) ) | ( ( 'Relationship_Constraints' ) ) | ( ( 'Relationships' ) ) | ( ( 'RML_Feature_Model' ) ) | ( ( 'Role_Behavior' ) ) | ( ( 'Role_Constraints' ) ) | ( ( 'Role_Equivalence' ) ) | ( ( 'Role_Implication' ) ) | ( ( 'Role_Inheritance' ) ) | ( ( 'Role_Prohibition' ) ) | ( ( 'Role_Properties' ) ) | ( ( 'Role_Structure' ) ) | ( ( 'Role_Types' ) ) | ( ( 'Roles' ) ) )
            int alt10=37;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt10=1;
                }
                break;
            case 40:
                {
                alt10=2;
                }
                break;
            case 41:
                {
                alt10=3;
                }
                break;
            case 42:
                {
                alt10=4;
                }
                break;
            case 43:
                {
                alt10=5;
                }
                break;
            case 44:
                {
                alt10=6;
                }
                break;
            case 45:
                {
                alt10=7;
                }
                break;
            case 46:
                {
                alt10=8;
                }
                break;
            case 47:
                {
                alt10=9;
                }
                break;
            case 48:
                {
                alt10=10;
                }
                break;
            case 49:
                {
                alt10=11;
                }
                break;
            case 50:
                {
                alt10=12;
                }
                break;
            case 51:
                {
                alt10=13;
                }
                break;
            case 52:
                {
                alt10=14;
                }
                break;
            case 53:
                {
                alt10=15;
                }
                break;
            case 54:
                {
                alt10=16;
                }
                break;
            case 55:
                {
                alt10=17;
                }
                break;
            case 56:
                {
                alt10=18;
                }
                break;
            case 57:
                {
                alt10=19;
                }
                break;
            case 58:
                {
                alt10=20;
                }
                break;
            case 59:
                {
                alt10=21;
                }
                break;
            case 60:
                {
                alt10=22;
                }
                break;
            case 61:
                {
                alt10=23;
                }
                break;
            case 62:
                {
                alt10=24;
                }
                break;
            case 63:
                {
                alt10=25;
                }
                break;
            case 64:
                {
                alt10=26;
                }
                break;
            case 65:
                {
                alt10=27;
                }
                break;
            case 66:
                {
                alt10=28;
                }
                break;
            case 67:
                {
                alt10=29;
                }
                break;
            case 68:
                {
                alt10=30;
                }
                break;
            case 69:
                {
                alt10=31;
                }
                break;
            case 70:
                {
                alt10=32;
                }
                break;
            case 71:
                {
                alt10=33;
                }
                break;
            case 72:
                {
                alt10=34;
                }
                break;
            case 73:
                {
                alt10=35;
                }
                break;
            case 74:
                {
                alt10=36;
                }
                break;
            case 75:
                {
                alt10=37;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalDsl.g:1171:2: ( ( 'Compartment_Behavior' ) )
                    {
                    // InternalDsl.g:1171:2: ( ( 'Compartment_Behavior' ) )
                    // InternalDsl.g:1172:3: ( 'Compartment_Behavior' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getCompartment_BehaviorEnumLiteralDeclaration_0()); 
                    // InternalDsl.g:1173:3: ( 'Compartment_Behavior' )
                    // InternalDsl.g:1173:4: 'Compartment_Behavior'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getCompartment_BehaviorEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDsl.g:1177:2: ( ( 'Compartment_Inheritance' ) )
                    {
                    // InternalDsl.g:1177:2: ( ( 'Compartment_Inheritance' ) )
                    // InternalDsl.g:1178:3: ( 'Compartment_Inheritance' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getCompartment_InheritanceEnumLiteralDeclaration_1()); 
                    // InternalDsl.g:1179:3: ( 'Compartment_Inheritance' )
                    // InternalDsl.g:1179:4: 'Compartment_Inheritance'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getCompartment_InheritanceEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDsl.g:1183:2: ( ( 'Compartment_Properties' ) )
                    {
                    // InternalDsl.g:1183:2: ( ( 'Compartment_Properties' ) )
                    // InternalDsl.g:1184:3: ( 'Compartment_Properties' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getCompartment_PropertiesEnumLiteralDeclaration_2()); 
                    // InternalDsl.g:1185:3: ( 'Compartment_Properties' )
                    // InternalDsl.g:1185:4: 'Compartment_Properties'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getCompartment_PropertiesEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDsl.g:1189:2: ( ( 'Compartment_Structure' ) )
                    {
                    // InternalDsl.g:1189:2: ( ( 'Compartment_Structure' ) )
                    // InternalDsl.g:1190:3: ( 'Compartment_Structure' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getCompartment_StructureEnumLiteralDeclaration_3()); 
                    // InternalDsl.g:1191:3: ( 'Compartment_Structure' )
                    // InternalDsl.g:1191:4: 'Compartment_Structure'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getCompartment_StructureEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDsl.g:1195:2: ( ( 'Compartment_Types' ) )
                    {
                    // InternalDsl.g:1195:2: ( ( 'Compartment_Types' ) )
                    // InternalDsl.g:1196:3: ( 'Compartment_Types' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getCompartment_TypesEnumLiteralDeclaration_4()); 
                    // InternalDsl.g:1197:3: ( 'Compartment_Types' )
                    // InternalDsl.g:1197:4: 'Compartment_Types'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getCompartment_TypesEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDsl.g:1201:2: ( ( 'Contains_Compartments' ) )
                    {
                    // InternalDsl.g:1201:2: ( ( 'Contains_Compartments' ) )
                    // InternalDsl.g:1202:3: ( 'Contains_Compartments' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getContains_CompartmentsEnumLiteralDeclaration_5()); 
                    // InternalDsl.g:1203:3: ( 'Contains_Compartments' )
                    // InternalDsl.g:1203:4: 'Contains_Compartments'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getContains_CompartmentsEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDsl.g:1207:2: ( ( 'Compartments' ) )
                    {
                    // InternalDsl.g:1207:2: ( ( 'Compartments' ) )
                    // InternalDsl.g:1208:3: ( 'Compartments' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getCompartmentsEnumLiteralDeclaration_6()); 
                    // InternalDsl.g:1209:3: ( 'Compartments' )
                    // InternalDsl.g:1209:4: 'Compartments'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getCompartmentsEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDsl.g:1213:2: ( ( 'Data_Type_Inheritance' ) )
                    {
                    // InternalDsl.g:1213:2: ( ( 'Data_Type_Inheritance' ) )
                    // InternalDsl.g:1214:3: ( 'Data_Type_Inheritance' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getData_Type_InheritanceEnumLiteralDeclaration_7()); 
                    // InternalDsl.g:1215:3: ( 'Data_Type_Inheritance' )
                    // InternalDsl.g:1215:4: 'Data_Type_Inheritance'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getData_Type_InheritanceEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDsl.g:1219:2: ( ( 'Data_Types' ) )
                    {
                    // InternalDsl.g:1219:2: ( ( 'Data_Types' ) )
                    // InternalDsl.g:1220:3: ( 'Data_Types' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getData_TypesEnumLiteralDeclaration_8()); 
                    // InternalDsl.g:1221:3: ( 'Data_Types' )
                    // InternalDsl.g:1221:4: 'Data_Types'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getData_TypesEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDsl.g:1225:2: ( ( 'Dates' ) )
                    {
                    // InternalDsl.g:1225:2: ( ( 'Dates' ) )
                    // InternalDsl.g:1226:3: ( 'Dates' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getDatesEnumLiteralDeclaration_9()); 
                    // InternalDsl.g:1227:3: ( 'Dates' )
                    // InternalDsl.g:1227:4: 'Dates'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getDatesEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDsl.g:1231:2: ( ( 'Dependent' ) )
                    {
                    // InternalDsl.g:1231:2: ( ( 'Dependent' ) )
                    // InternalDsl.g:1232:3: ( 'Dependent' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getDependentEnumLiteralDeclaration_10()); 
                    // InternalDsl.g:1233:3: ( 'Dependent' )
                    // InternalDsl.g:1233:4: 'Dependent'
                    {
                    match(input,49,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getDependentEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDsl.g:1237:2: ( ( 'Group_Constraints' ) )
                    {
                    // InternalDsl.g:1237:2: ( ( 'Group_Constraints' ) )
                    // InternalDsl.g:1238:3: ( 'Group_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getGroup_ConstraintsEnumLiteralDeclaration_11()); 
                    // InternalDsl.g:1239:3: ( 'Group_Constraints' )
                    // InternalDsl.g:1239:4: 'Group_Constraints'
                    {
                    match(input,50,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getGroup_ConstraintsEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDsl.g:1243:2: ( ( 'Inter_Relationship_Constraints' ) )
                    {
                    // InternalDsl.g:1243:2: ( ( 'Inter_Relationship_Constraints' ) )
                    // InternalDsl.g:1244:3: ( 'Inter_Relationship_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getInter_Relationship_ConstraintsEnumLiteralDeclaration_12()); 
                    // InternalDsl.g:1245:3: ( 'Inter_Relationship_Constraints' )
                    // InternalDsl.g:1245:4: 'Inter_Relationship_Constraints'
                    {
                    match(input,51,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getInter_Relationship_ConstraintsEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDsl.g:1249:2: ( ( 'Intra_Relationship_Constraints' ) )
                    {
                    // InternalDsl.g:1249:2: ( ( 'Intra_Relationship_Constraints' ) )
                    // InternalDsl.g:1250:3: ( 'Intra_Relationship_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getIntra_Relationship_ConstraintsEnumLiteralDeclaration_13()); 
                    // InternalDsl.g:1251:3: ( 'Intra_Relationship_Constraints' )
                    // InternalDsl.g:1251:4: 'Intra_Relationship_Constraints'
                    {
                    match(input,52,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getIntra_Relationship_ConstraintsEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDsl.g:1255:2: ( ( 'Naturals' ) )
                    {
                    // InternalDsl.g:1255:2: ( ( 'Naturals' ) )
                    // InternalDsl.g:1256:3: ( 'Naturals' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getNaturalsEnumLiteralDeclaration_14()); 
                    // InternalDsl.g:1257:3: ( 'Naturals' )
                    // InternalDsl.g:1257:4: 'Naturals'
                    {
                    match(input,53,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getNaturalsEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDsl.g:1261:2: ( ( 'Occurrence_Constraints' ) )
                    {
                    // InternalDsl.g:1261:2: ( ( 'Occurrence_Constraints' ) )
                    // InternalDsl.g:1262:3: ( 'Occurrence_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getOccurrence_ConstraintsEnumLiteralDeclaration_15()); 
                    // InternalDsl.g:1263:3: ( 'Occurrence_Constraints' )
                    // InternalDsl.g:1263:4: 'Occurrence_Constraints'
                    {
                    match(input,54,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getOccurrence_ConstraintsEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDsl.g:1267:2: ( ( 'On_Compartments' ) )
                    {
                    // InternalDsl.g:1267:2: ( ( 'On_Compartments' ) )
                    // InternalDsl.g:1268:3: ( 'On_Compartments' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getOn_CompartmentsEnumLiteralDeclaration_16()); 
                    // InternalDsl.g:1269:3: ( 'On_Compartments' )
                    // InternalDsl.g:1269:4: 'On_Compartments'
                    {
                    match(input,55,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getOn_CompartmentsEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDsl.g:1273:2: ( ( 'On_Relationships' ) )
                    {
                    // InternalDsl.g:1273:2: ( ( 'On_Relationships' ) )
                    // InternalDsl.g:1274:3: ( 'On_Relationships' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getOn_RelationshipsEnumLiteralDeclaration_17()); 
                    // InternalDsl.g:1275:3: ( 'On_Relationships' )
                    // InternalDsl.g:1275:4: 'On_Relationships'
                    {
                    match(input,56,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getOn_RelationshipsEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDsl.g:1279:2: ( ( 'Parthood_Constraints' ) )
                    {
                    // InternalDsl.g:1279:2: ( ( 'Parthood_Constraints' ) )
                    // InternalDsl.g:1280:3: ( 'Parthood_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getParthood_ConstraintsEnumLiteralDeclaration_18()); 
                    // InternalDsl.g:1281:3: ( 'Parthood_Constraints' )
                    // InternalDsl.g:1281:4: 'Parthood_Constraints'
                    {
                    match(input,57,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getParthood_ConstraintsEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDsl.g:1285:2: ( ( 'Participants' ) )
                    {
                    // InternalDsl.g:1285:2: ( ( 'Participants' ) )
                    // InternalDsl.g:1286:3: ( 'Participants' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getParticipantsEnumLiteralDeclaration_19()); 
                    // InternalDsl.g:1287:3: ( 'Participants' )
                    // InternalDsl.g:1287:4: 'Participants'
                    {
                    match(input,58,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getParticipantsEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDsl.g:1291:2: ( ( 'Playable' ) )
                    {
                    // InternalDsl.g:1291:2: ( ( 'Playable' ) )
                    // InternalDsl.g:1292:3: ( 'Playable' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getPlayableEnumLiteralDeclaration_20()); 
                    // InternalDsl.g:1293:3: ( 'Playable' )
                    // InternalDsl.g:1293:4: 'Playable'
                    {
                    match(input,59,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getPlayableEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDsl.g:1297:2: ( ( 'Playable_by_Defining_Compartment' ) )
                    {
                    // InternalDsl.g:1297:2: ( ( 'Playable_by_Defining_Compartment' ) )
                    // InternalDsl.g:1298:3: ( 'Playable_by_Defining_Compartment' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getPlayable_by_Defining_CompartmentEnumLiteralDeclaration_21()); 
                    // InternalDsl.g:1299:3: ( 'Playable_by_Defining_Compartment' )
                    // InternalDsl.g:1299:4: 'Playable_by_Defining_Compartment'
                    {
                    match(input,60,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getPlayable_by_Defining_CompartmentEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDsl.g:1303:2: ( ( 'Players' ) )
                    {
                    // InternalDsl.g:1303:2: ( ( 'Players' ) )
                    // InternalDsl.g:1304:3: ( 'Players' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getPlayersEnumLiteralDeclaration_22()); 
                    // InternalDsl.g:1305:3: ( 'Players' )
                    // InternalDsl.g:1305:4: 'Players'
                    {
                    match(input,61,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getPlayersEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDsl.g:1309:2: ( ( 'Relationship_Cardinality' ) )
                    {
                    // InternalDsl.g:1309:2: ( ( 'Relationship_Cardinality' ) )
                    // InternalDsl.g:1310:3: ( 'Relationship_Cardinality' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRelationship_CardinalityEnumLiteralDeclaration_23()); 
                    // InternalDsl.g:1311:3: ( 'Relationship_Cardinality' )
                    // InternalDsl.g:1311:4: 'Relationship_Cardinality'
                    {
                    match(input,62,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRelationship_CardinalityEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDsl.g:1315:2: ( ( 'Relationship_Constraints' ) )
                    {
                    // InternalDsl.g:1315:2: ( ( 'Relationship_Constraints' ) )
                    // InternalDsl.g:1316:3: ( 'Relationship_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRelationship_ConstraintsEnumLiteralDeclaration_24()); 
                    // InternalDsl.g:1317:3: ( 'Relationship_Constraints' )
                    // InternalDsl.g:1317:4: 'Relationship_Constraints'
                    {
                    match(input,63,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRelationship_ConstraintsEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDsl.g:1321:2: ( ( 'Relationships' ) )
                    {
                    // InternalDsl.g:1321:2: ( ( 'Relationships' ) )
                    // InternalDsl.g:1322:3: ( 'Relationships' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRelationshipsEnumLiteralDeclaration_25()); 
                    // InternalDsl.g:1323:3: ( 'Relationships' )
                    // InternalDsl.g:1323:4: 'Relationships'
                    {
                    match(input,64,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRelationshipsEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDsl.g:1327:2: ( ( 'RML_Feature_Model' ) )
                    {
                    // InternalDsl.g:1327:2: ( ( 'RML_Feature_Model' ) )
                    // InternalDsl.g:1328:3: ( 'RML_Feature_Model' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRML_Feature_ModelEnumLiteralDeclaration_26()); 
                    // InternalDsl.g:1329:3: ( 'RML_Feature_Model' )
                    // InternalDsl.g:1329:4: 'RML_Feature_Model'
                    {
                    match(input,65,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRML_Feature_ModelEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDsl.g:1333:2: ( ( 'Role_Behavior' ) )
                    {
                    // InternalDsl.g:1333:2: ( ( 'Role_Behavior' ) )
                    // InternalDsl.g:1334:3: ( 'Role_Behavior' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_BehaviorEnumLiteralDeclaration_27()); 
                    // InternalDsl.g:1335:3: ( 'Role_Behavior' )
                    // InternalDsl.g:1335:4: 'Role_Behavior'
                    {
                    match(input,66,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_BehaviorEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDsl.g:1339:2: ( ( 'Role_Constraints' ) )
                    {
                    // InternalDsl.g:1339:2: ( ( 'Role_Constraints' ) )
                    // InternalDsl.g:1340:3: ( 'Role_Constraints' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_ConstraintsEnumLiteralDeclaration_28()); 
                    // InternalDsl.g:1341:3: ( 'Role_Constraints' )
                    // InternalDsl.g:1341:4: 'Role_Constraints'
                    {
                    match(input,67,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_ConstraintsEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDsl.g:1345:2: ( ( 'Role_Equivalence' ) )
                    {
                    // InternalDsl.g:1345:2: ( ( 'Role_Equivalence' ) )
                    // InternalDsl.g:1346:3: ( 'Role_Equivalence' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_EquivalenceEnumLiteralDeclaration_29()); 
                    // InternalDsl.g:1347:3: ( 'Role_Equivalence' )
                    // InternalDsl.g:1347:4: 'Role_Equivalence'
                    {
                    match(input,68,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_EquivalenceEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDsl.g:1351:2: ( ( 'Role_Implication' ) )
                    {
                    // InternalDsl.g:1351:2: ( ( 'Role_Implication' ) )
                    // InternalDsl.g:1352:3: ( 'Role_Implication' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_ImplicationEnumLiteralDeclaration_30()); 
                    // InternalDsl.g:1353:3: ( 'Role_Implication' )
                    // InternalDsl.g:1353:4: 'Role_Implication'
                    {
                    match(input,69,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_ImplicationEnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDsl.g:1357:2: ( ( 'Role_Inheritance' ) )
                    {
                    // InternalDsl.g:1357:2: ( ( 'Role_Inheritance' ) )
                    // InternalDsl.g:1358:3: ( 'Role_Inheritance' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_InheritanceEnumLiteralDeclaration_31()); 
                    // InternalDsl.g:1359:3: ( 'Role_Inheritance' )
                    // InternalDsl.g:1359:4: 'Role_Inheritance'
                    {
                    match(input,70,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_InheritanceEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDsl.g:1363:2: ( ( 'Role_Prohibition' ) )
                    {
                    // InternalDsl.g:1363:2: ( ( 'Role_Prohibition' ) )
                    // InternalDsl.g:1364:3: ( 'Role_Prohibition' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_ProhibitionEnumLiteralDeclaration_32()); 
                    // InternalDsl.g:1365:3: ( 'Role_Prohibition' )
                    // InternalDsl.g:1365:4: 'Role_Prohibition'
                    {
                    match(input,71,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_ProhibitionEnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDsl.g:1369:2: ( ( 'Role_Properties' ) )
                    {
                    // InternalDsl.g:1369:2: ( ( 'Role_Properties' ) )
                    // InternalDsl.g:1370:3: ( 'Role_Properties' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_PropertiesEnumLiteralDeclaration_33()); 
                    // InternalDsl.g:1371:3: ( 'Role_Properties' )
                    // InternalDsl.g:1371:4: 'Role_Properties'
                    {
                    match(input,72,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_PropertiesEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDsl.g:1375:2: ( ( 'Role_Structure' ) )
                    {
                    // InternalDsl.g:1375:2: ( ( 'Role_Structure' ) )
                    // InternalDsl.g:1376:3: ( 'Role_Structure' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_StructureEnumLiteralDeclaration_34()); 
                    // InternalDsl.g:1377:3: ( 'Role_Structure' )
                    // InternalDsl.g:1377:4: 'Role_Structure'
                    {
                    match(input,73,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_StructureEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDsl.g:1381:2: ( ( 'Role_Types' ) )
                    {
                    // InternalDsl.g:1381:2: ( ( 'Role_Types' ) )
                    // InternalDsl.g:1382:3: ( 'Role_Types' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRole_TypesEnumLiteralDeclaration_35()); 
                    // InternalDsl.g:1383:3: ( 'Role_Types' )
                    // InternalDsl.g:1383:4: 'Role_Types'
                    {
                    match(input,74,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRole_TypesEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDsl.g:1387:2: ( ( 'Roles' ) )
                    {
                    // InternalDsl.g:1387:2: ( ( 'Roles' ) )
                    // InternalDsl.g:1388:3: ( 'Roles' )
                    {
                     before(grammarAccess.getFeatureNameEnumAccess().getRolesEnumLiteralDeclaration_36()); 
                    // InternalDsl.g:1389:3: ( 'Roles' )
                    // InternalDsl.g:1389:4: 'Roles'
                    {
                    match(input,75,FOLLOW_2); 

                    }

                     after(grammarAccess.getFeatureNameEnumAccess().getRolesEnumLiteralDeclaration_36()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureNameEnum__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalDsl.g:1397:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1401:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalDsl.g:1402:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalDsl.g:1409:1: rule__Model__Group__0__Impl : ( ( rule__Model__PoliciesAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1413:1: ( ( ( rule__Model__PoliciesAssignment_0 ) ) )
            // InternalDsl.g:1414:1: ( ( rule__Model__PoliciesAssignment_0 ) )
            {
            // InternalDsl.g:1414:1: ( ( rule__Model__PoliciesAssignment_0 ) )
            // InternalDsl.g:1415:2: ( rule__Model__PoliciesAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getPoliciesAssignment_0()); 
            // InternalDsl.g:1416:2: ( rule__Model__PoliciesAssignment_0 )
            // InternalDsl.g:1416:3: rule__Model__PoliciesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__PoliciesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPoliciesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalDsl.g:1424:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1428:1: ( rule__Model__Group__1__Impl )
            // InternalDsl.g:1429:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalDsl.g:1435:1: rule__Model__Group__1__Impl : ( ( rule__Model__PoliciesAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1439:1: ( ( ( rule__Model__PoliciesAssignment_1 )* ) )
            // InternalDsl.g:1440:1: ( ( rule__Model__PoliciesAssignment_1 )* )
            {
            // InternalDsl.g:1440:1: ( ( rule__Model__PoliciesAssignment_1 )* )
            // InternalDsl.g:1441:2: ( rule__Model__PoliciesAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getPoliciesAssignment_1()); 
            // InternalDsl.g:1442:2: ( rule__Model__PoliciesAssignment_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=11 && LA11_0<=20)||LA11_0==94) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDsl.g:1442:3: rule__Model__PoliciesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Model__PoliciesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getPoliciesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Policy__Group__0"
    // InternalDsl.g:1451:1: rule__Policy__Group__0 : rule__Policy__Group__0__Impl rule__Policy__Group__1 ;
    public final void rule__Policy__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1455:1: ( rule__Policy__Group__0__Impl rule__Policy__Group__1 )
            // InternalDsl.g:1456:2: rule__Policy__Group__0__Impl rule__Policy__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Policy__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__0"


    // $ANTLR start "rule__Policy__Group__0__Impl"
    // InternalDsl.g:1463:1: rule__Policy__Group__0__Impl : ( ( rule__Policy__OverrideAssignment_0 )? ) ;
    public final void rule__Policy__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1467:1: ( ( ( rule__Policy__OverrideAssignment_0 )? ) )
            // InternalDsl.g:1468:1: ( ( rule__Policy__OverrideAssignment_0 )? )
            {
            // InternalDsl.g:1468:1: ( ( rule__Policy__OverrideAssignment_0 )? )
            // InternalDsl.g:1469:2: ( rule__Policy__OverrideAssignment_0 )?
            {
             before(grammarAccess.getPolicyAccess().getOverrideAssignment_0()); 
            // InternalDsl.g:1470:2: ( rule__Policy__OverrideAssignment_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==94) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDsl.g:1470:3: rule__Policy__OverrideAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Policy__OverrideAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPolicyAccess().getOverrideAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__0__Impl"


    // $ANTLR start "rule__Policy__Group__1"
    // InternalDsl.g:1478:1: rule__Policy__Group__1 : rule__Policy__Group__1__Impl rule__Policy__Group__2 ;
    public final void rule__Policy__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1482:1: ( rule__Policy__Group__1__Impl rule__Policy__Group__2 )
            // InternalDsl.g:1483:2: rule__Policy__Group__1__Impl rule__Policy__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Policy__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__1"


    // $ANTLR start "rule__Policy__Group__1__Impl"
    // InternalDsl.g:1490:1: rule__Policy__Group__1__Impl : ( ( rule__Policy__ActionAssignment_1 ) ) ;
    public final void rule__Policy__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1494:1: ( ( ( rule__Policy__ActionAssignment_1 ) ) )
            // InternalDsl.g:1495:1: ( ( rule__Policy__ActionAssignment_1 ) )
            {
            // InternalDsl.g:1495:1: ( ( rule__Policy__ActionAssignment_1 ) )
            // InternalDsl.g:1496:2: ( rule__Policy__ActionAssignment_1 )
            {
             before(grammarAccess.getPolicyAccess().getActionAssignment_1()); 
            // InternalDsl.g:1497:2: ( rule__Policy__ActionAssignment_1 )
            // InternalDsl.g:1497:3: rule__Policy__ActionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Policy__ActionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPolicyAccess().getActionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__1__Impl"


    // $ANTLR start "rule__Policy__Group__2"
    // InternalDsl.g:1505:1: rule__Policy__Group__2 : rule__Policy__Group__2__Impl rule__Policy__Group__3 ;
    public final void rule__Policy__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1509:1: ( rule__Policy__Group__2__Impl rule__Policy__Group__3 )
            // InternalDsl.g:1510:2: rule__Policy__Group__2__Impl rule__Policy__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Policy__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__2"


    // $ANTLR start "rule__Policy__Group__2__Impl"
    // InternalDsl.g:1517:1: rule__Policy__Group__2__Impl : ( ( rule__Policy__ActionTypeAssignment_2 ) ) ;
    public final void rule__Policy__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1521:1: ( ( ( rule__Policy__ActionTypeAssignment_2 ) ) )
            // InternalDsl.g:1522:1: ( ( rule__Policy__ActionTypeAssignment_2 ) )
            {
            // InternalDsl.g:1522:1: ( ( rule__Policy__ActionTypeAssignment_2 ) )
            // InternalDsl.g:1523:2: ( rule__Policy__ActionTypeAssignment_2 )
            {
             before(grammarAccess.getPolicyAccess().getActionTypeAssignment_2()); 
            // InternalDsl.g:1524:2: ( rule__Policy__ActionTypeAssignment_2 )
            // InternalDsl.g:1524:3: rule__Policy__ActionTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Policy__ActionTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPolicyAccess().getActionTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__2__Impl"


    // $ANTLR start "rule__Policy__Group__3"
    // InternalDsl.g:1532:1: rule__Policy__Group__3 : rule__Policy__Group__3__Impl rule__Policy__Group__4 ;
    public final void rule__Policy__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1536:1: ( rule__Policy__Group__3__Impl rule__Policy__Group__4 )
            // InternalDsl.g:1537:2: rule__Policy__Group__3__Impl rule__Policy__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Policy__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__3"


    // $ANTLR start "rule__Policy__Group__3__Impl"
    // InternalDsl.g:1544:1: rule__Policy__Group__3__Impl : ( '(' ) ;
    public final void rule__Policy__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1548:1: ( ( '(' ) )
            // InternalDsl.g:1549:1: ( '(' )
            {
            // InternalDsl.g:1549:1: ( '(' )
            // InternalDsl.g:1550:2: '('
            {
             before(grammarAccess.getPolicyAccess().getLeftParenthesisKeyword_3()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getPolicyAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__3__Impl"


    // $ANTLR start "rule__Policy__Group__4"
    // InternalDsl.g:1559:1: rule__Policy__Group__4 : rule__Policy__Group__4__Impl rule__Policy__Group__5 ;
    public final void rule__Policy__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1563:1: ( rule__Policy__Group__4__Impl rule__Policy__Group__5 )
            // InternalDsl.g:1564:2: rule__Policy__Group__4__Impl rule__Policy__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Policy__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__4"


    // $ANTLR start "rule__Policy__Group__4__Impl"
    // InternalDsl.g:1571:1: rule__Policy__Group__4__Impl : ( ( rule__Policy__FeatureRuleAssignment_4 ) ) ;
    public final void rule__Policy__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1575:1: ( ( ( rule__Policy__FeatureRuleAssignment_4 ) ) )
            // InternalDsl.g:1576:1: ( ( rule__Policy__FeatureRuleAssignment_4 ) )
            {
            // InternalDsl.g:1576:1: ( ( rule__Policy__FeatureRuleAssignment_4 ) )
            // InternalDsl.g:1577:2: ( rule__Policy__FeatureRuleAssignment_4 )
            {
             before(grammarAccess.getPolicyAccess().getFeatureRuleAssignment_4()); 
            // InternalDsl.g:1578:2: ( rule__Policy__FeatureRuleAssignment_4 )
            // InternalDsl.g:1578:3: rule__Policy__FeatureRuleAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Policy__FeatureRuleAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPolicyAccess().getFeatureRuleAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__4__Impl"


    // $ANTLR start "rule__Policy__Group__5"
    // InternalDsl.g:1586:1: rule__Policy__Group__5 : rule__Policy__Group__5__Impl rule__Policy__Group__6 ;
    public final void rule__Policy__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1590:1: ( rule__Policy__Group__5__Impl rule__Policy__Group__6 )
            // InternalDsl.g:1591:2: rule__Policy__Group__5__Impl rule__Policy__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Policy__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__5"


    // $ANTLR start "rule__Policy__Group__5__Impl"
    // InternalDsl.g:1598:1: rule__Policy__Group__5__Impl : ( ')' ) ;
    public final void rule__Policy__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1602:1: ( ( ')' ) )
            // InternalDsl.g:1603:1: ( ')' )
            {
            // InternalDsl.g:1603:1: ( ')' )
            // InternalDsl.g:1604:2: ')'
            {
             before(grammarAccess.getPolicyAccess().getRightParenthesisKeyword_5()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPolicyAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__5__Impl"


    // $ANTLR start "rule__Policy__Group__6"
    // InternalDsl.g:1613:1: rule__Policy__Group__6 : rule__Policy__Group__6__Impl rule__Policy__Group__7 ;
    public final void rule__Policy__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1617:1: ( rule__Policy__Group__6__Impl rule__Policy__Group__7 )
            // InternalDsl.g:1618:2: rule__Policy__Group__6__Impl rule__Policy__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Policy__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__6"


    // $ANTLR start "rule__Policy__Group__6__Impl"
    // InternalDsl.g:1625:1: rule__Policy__Group__6__Impl : ( 'when' ) ;
    public final void rule__Policy__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1629:1: ( ( 'when' ) )
            // InternalDsl.g:1630:1: ( 'when' )
            {
            // InternalDsl.g:1630:1: ( 'when' )
            // InternalDsl.g:1631:2: 'when'
            {
             before(grammarAccess.getPolicyAccess().getWhenKeyword_6()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getPolicyAccess().getWhenKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__6__Impl"


    // $ANTLR start "rule__Policy__Group__7"
    // InternalDsl.g:1640:1: rule__Policy__Group__7 : rule__Policy__Group__7__Impl rule__Policy__Group__8 ;
    public final void rule__Policy__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1644:1: ( rule__Policy__Group__7__Impl rule__Policy__Group__8 )
            // InternalDsl.g:1645:2: rule__Policy__Group__7__Impl rule__Policy__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__Policy__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Policy__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__7"


    // $ANTLR start "rule__Policy__Group__7__Impl"
    // InternalDsl.g:1652:1: rule__Policy__Group__7__Impl : ( ( rule__Policy__ConstraintRuleAssignment_7 ) ) ;
    public final void rule__Policy__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1656:1: ( ( ( rule__Policy__ConstraintRuleAssignment_7 ) ) )
            // InternalDsl.g:1657:1: ( ( rule__Policy__ConstraintRuleAssignment_7 ) )
            {
            // InternalDsl.g:1657:1: ( ( rule__Policy__ConstraintRuleAssignment_7 ) )
            // InternalDsl.g:1658:2: ( rule__Policy__ConstraintRuleAssignment_7 )
            {
             before(grammarAccess.getPolicyAccess().getConstraintRuleAssignment_7()); 
            // InternalDsl.g:1659:2: ( rule__Policy__ConstraintRuleAssignment_7 )
            // InternalDsl.g:1659:3: rule__Policy__ConstraintRuleAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Policy__ConstraintRuleAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getPolicyAccess().getConstraintRuleAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__7__Impl"


    // $ANTLR start "rule__Policy__Group__8"
    // InternalDsl.g:1667:1: rule__Policy__Group__8 : rule__Policy__Group__8__Impl ;
    public final void rule__Policy__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1671:1: ( rule__Policy__Group__8__Impl )
            // InternalDsl.g:1672:2: rule__Policy__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Policy__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__8"


    // $ANTLR start "rule__Policy__Group__8__Impl"
    // InternalDsl.g:1678:1: rule__Policy__Group__8__Impl : ( ';' ) ;
    public final void rule__Policy__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1682:1: ( ( ';' ) )
            // InternalDsl.g:1683:1: ( ';' )
            {
            // InternalDsl.g:1683:1: ( ';' )
            // InternalDsl.g:1684:2: ';'
            {
             before(grammarAccess.getPolicyAccess().getSemicolonKeyword_8()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getPolicyAccess().getSemicolonKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__Group__8__Impl"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__0"
    // InternalDsl.g:1694:1: rule__ContainsCompartmentConstrainRule__Group__0 : rule__ContainsCompartmentConstrainRule__Group__0__Impl rule__ContainsCompartmentConstrainRule__Group__1 ;
    public final void rule__ContainsCompartmentConstrainRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1698:1: ( rule__ContainsCompartmentConstrainRule__Group__0__Impl rule__ContainsCompartmentConstrainRule__Group__1 )
            // InternalDsl.g:1699:2: rule__ContainsCompartmentConstrainRule__Group__0__Impl rule__ContainsCompartmentConstrainRule__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__ContainsCompartmentConstrainRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContainsCompartmentConstrainRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__0"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__0__Impl"
    // InternalDsl.g:1706:1: rule__ContainsCompartmentConstrainRule__Group__0__Impl : ( () ) ;
    public final void rule__ContainsCompartmentConstrainRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1710:1: ( ( () ) )
            // InternalDsl.g:1711:1: ( () )
            {
            // InternalDsl.g:1711:1: ( () )
            // InternalDsl.g:1712:2: ()
            {
             before(grammarAccess.getContainsCompartmentConstrainRuleAccess().getContainsCompartmentAction_0()); 
            // InternalDsl.g:1713:2: ()
            // InternalDsl.g:1713:3: 
            {
            }

             after(grammarAccess.getContainsCompartmentConstrainRuleAccess().getContainsCompartmentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__0__Impl"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__1"
    // InternalDsl.g:1721:1: rule__ContainsCompartmentConstrainRule__Group__1 : rule__ContainsCompartmentConstrainRule__Group__1__Impl rule__ContainsCompartmentConstrainRule__Group__2 ;
    public final void rule__ContainsCompartmentConstrainRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1725:1: ( rule__ContainsCompartmentConstrainRule__Group__1__Impl rule__ContainsCompartmentConstrainRule__Group__2 )
            // InternalDsl.g:1726:2: rule__ContainsCompartmentConstrainRule__Group__1__Impl rule__ContainsCompartmentConstrainRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__ContainsCompartmentConstrainRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContainsCompartmentConstrainRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__1"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__1__Impl"
    // InternalDsl.g:1733:1: rule__ContainsCompartmentConstrainRule__Group__1__Impl : ( 'ContainsCompartment' ) ;
    public final void rule__ContainsCompartmentConstrainRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1737:1: ( ( 'ContainsCompartment' ) )
            // InternalDsl.g:1738:1: ( 'ContainsCompartment' )
            {
            // InternalDsl.g:1738:1: ( 'ContainsCompartment' )
            // InternalDsl.g:1739:2: 'ContainsCompartment'
            {
             before(grammarAccess.getContainsCompartmentConstrainRuleAccess().getContainsCompartmentKeyword_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getContainsCompartmentConstrainRuleAccess().getContainsCompartmentKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__1__Impl"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__2"
    // InternalDsl.g:1748:1: rule__ContainsCompartmentConstrainRule__Group__2 : rule__ContainsCompartmentConstrainRule__Group__2__Impl rule__ContainsCompartmentConstrainRule__Group__3 ;
    public final void rule__ContainsCompartmentConstrainRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1752:1: ( rule__ContainsCompartmentConstrainRule__Group__2__Impl rule__ContainsCompartmentConstrainRule__Group__3 )
            // InternalDsl.g:1753:2: rule__ContainsCompartmentConstrainRule__Group__2__Impl rule__ContainsCompartmentConstrainRule__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ContainsCompartmentConstrainRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContainsCompartmentConstrainRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__2"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__2__Impl"
    // InternalDsl.g:1760:1: rule__ContainsCompartmentConstrainRule__Group__2__Impl : ( '(' ) ;
    public final void rule__ContainsCompartmentConstrainRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1764:1: ( ( '(' ) )
            // InternalDsl.g:1765:1: ( '(' )
            {
            // InternalDsl.g:1765:1: ( '(' )
            // InternalDsl.g:1766:2: '('
            {
             before(grammarAccess.getContainsCompartmentConstrainRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getContainsCompartmentConstrainRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__2__Impl"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__3"
    // InternalDsl.g:1775:1: rule__ContainsCompartmentConstrainRule__Group__3 : rule__ContainsCompartmentConstrainRule__Group__3__Impl ;
    public final void rule__ContainsCompartmentConstrainRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1779:1: ( rule__ContainsCompartmentConstrainRule__Group__3__Impl )
            // InternalDsl.g:1780:2: rule__ContainsCompartmentConstrainRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ContainsCompartmentConstrainRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__3"


    // $ANTLR start "rule__ContainsCompartmentConstrainRule__Group__3__Impl"
    // InternalDsl.g:1786:1: rule__ContainsCompartmentConstrainRule__Group__3__Impl : ( ')' ) ;
    public final void rule__ContainsCompartmentConstrainRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1790:1: ( ( ')' ) )
            // InternalDsl.g:1791:1: ( ')' )
            {
            // InternalDsl.g:1791:1: ( ')' )
            // InternalDsl.g:1792:2: ')'
            {
             before(grammarAccess.getContainsCompartmentConstrainRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getContainsCompartmentConstrainRuleAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainsCompartmentConstrainRule__Group__3__Impl"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__0"
    // InternalDsl.g:1802:1: rule__IsTargetTypeConstraintRule__Group__0 : rule__IsTargetTypeConstraintRule__Group__0__Impl rule__IsTargetTypeConstraintRule__Group__1 ;
    public final void rule__IsTargetTypeConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1806:1: ( rule__IsTargetTypeConstraintRule__Group__0__Impl rule__IsTargetTypeConstraintRule__Group__1 )
            // InternalDsl.g:1807:2: rule__IsTargetTypeConstraintRule__Group__0__Impl rule__IsTargetTypeConstraintRule__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__IsTargetTypeConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__0"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__0__Impl"
    // InternalDsl.g:1814:1: rule__IsTargetTypeConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__IsTargetTypeConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1818:1: ( ( () ) )
            // InternalDsl.g:1819:1: ( () )
            {
            // InternalDsl.g:1819:1: ( () )
            // InternalDsl.g:1820:2: ()
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getIsTargetTypeAction_0()); 
            // InternalDsl.g:1821:2: ()
            // InternalDsl.g:1821:3: 
            {
            }

             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getIsTargetTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__1"
    // InternalDsl.g:1829:1: rule__IsTargetTypeConstraintRule__Group__1 : rule__IsTargetTypeConstraintRule__Group__1__Impl rule__IsTargetTypeConstraintRule__Group__2 ;
    public final void rule__IsTargetTypeConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1833:1: ( rule__IsTargetTypeConstraintRule__Group__1__Impl rule__IsTargetTypeConstraintRule__Group__2 )
            // InternalDsl.g:1834:2: rule__IsTargetTypeConstraintRule__Group__1__Impl rule__IsTargetTypeConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__IsTargetTypeConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__1"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__1__Impl"
    // InternalDsl.g:1841:1: rule__IsTargetTypeConstraintRule__Group__1__Impl : ( 'IsTargetType' ) ;
    public final void rule__IsTargetTypeConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1845:1: ( ( 'IsTargetType' ) )
            // InternalDsl.g:1846:1: ( 'IsTargetType' )
            {
            // InternalDsl.g:1846:1: ( 'IsTargetType' )
            // InternalDsl.g:1847:2: 'IsTargetType'
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getIsTargetTypeKeyword_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getIsTargetTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__2"
    // InternalDsl.g:1856:1: rule__IsTargetTypeConstraintRule__Group__2 : rule__IsTargetTypeConstraintRule__Group__2__Impl rule__IsTargetTypeConstraintRule__Group__3 ;
    public final void rule__IsTargetTypeConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1860:1: ( rule__IsTargetTypeConstraintRule__Group__2__Impl rule__IsTargetTypeConstraintRule__Group__3 )
            // InternalDsl.g:1861:2: rule__IsTargetTypeConstraintRule__Group__2__Impl rule__IsTargetTypeConstraintRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IsTargetTypeConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__2"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__2__Impl"
    // InternalDsl.g:1868:1: rule__IsTargetTypeConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__IsTargetTypeConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1872:1: ( ( '(' ) )
            // InternalDsl.g:1873:1: ( '(' )
            {
            // InternalDsl.g:1873:1: ( '(' )
            // InternalDsl.g:1874:2: '('
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__3"
    // InternalDsl.g:1883:1: rule__IsTargetTypeConstraintRule__Group__3 : rule__IsTargetTypeConstraintRule__Group__3__Impl rule__IsTargetTypeConstraintRule__Group__4 ;
    public final void rule__IsTargetTypeConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1887:1: ( rule__IsTargetTypeConstraintRule__Group__3__Impl rule__IsTargetTypeConstraintRule__Group__4 )
            // InternalDsl.g:1888:2: rule__IsTargetTypeConstraintRule__Group__3__Impl rule__IsTargetTypeConstraintRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__IsTargetTypeConstraintRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__3"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__3__Impl"
    // InternalDsl.g:1895:1: rule__IsTargetTypeConstraintRule__Group__3__Impl : ( ( rule__IsTargetTypeConstraintRule__TypeAssignment_3 ) ) ;
    public final void rule__IsTargetTypeConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1899:1: ( ( ( rule__IsTargetTypeConstraintRule__TypeAssignment_3 ) ) )
            // InternalDsl.g:1900:1: ( ( rule__IsTargetTypeConstraintRule__TypeAssignment_3 ) )
            {
            // InternalDsl.g:1900:1: ( ( rule__IsTargetTypeConstraintRule__TypeAssignment_3 ) )
            // InternalDsl.g:1901:2: ( rule__IsTargetTypeConstraintRule__TypeAssignment_3 )
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getTypeAssignment_3()); 
            // InternalDsl.g:1902:2: ( rule__IsTargetTypeConstraintRule__TypeAssignment_3 )
            // InternalDsl.g:1902:3: rule__IsTargetTypeConstraintRule__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__4"
    // InternalDsl.g:1910:1: rule__IsTargetTypeConstraintRule__Group__4 : rule__IsTargetTypeConstraintRule__Group__4__Impl ;
    public final void rule__IsTargetTypeConstraintRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1914:1: ( rule__IsTargetTypeConstraintRule__Group__4__Impl )
            // InternalDsl.g:1915:2: rule__IsTargetTypeConstraintRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsTargetTypeConstraintRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__4"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__Group__4__Impl"
    // InternalDsl.g:1921:1: rule__IsTargetTypeConstraintRule__Group__4__Impl : ( ')' ) ;
    public final void rule__IsTargetTypeConstraintRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1925:1: ( ( ')' ) )
            // InternalDsl.g:1926:1: ( ')' )
            {
            // InternalDsl.g:1926:1: ( ')' )
            // InternalDsl.g:1927:2: ')'
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getRightParenthesisKeyword_4()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__Group__4__Impl"


    // $ANTLR start "rule__IsParentConstraintRule__Group__0"
    // InternalDsl.g:1937:1: rule__IsParentConstraintRule__Group__0 : rule__IsParentConstraintRule__Group__0__Impl rule__IsParentConstraintRule__Group__1 ;
    public final void rule__IsParentConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1941:1: ( rule__IsParentConstraintRule__Group__0__Impl rule__IsParentConstraintRule__Group__1 )
            // InternalDsl.g:1942:2: rule__IsParentConstraintRule__Group__0__Impl rule__IsParentConstraintRule__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__IsParentConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__0"


    // $ANTLR start "rule__IsParentConstraintRule__Group__0__Impl"
    // InternalDsl.g:1949:1: rule__IsParentConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__IsParentConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1953:1: ( ( () ) )
            // InternalDsl.g:1954:1: ( () )
            {
            // InternalDsl.g:1954:1: ( () )
            // InternalDsl.g:1955:2: ()
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getIsParentAction_0()); 
            // InternalDsl.g:1956:2: ()
            // InternalDsl.g:1956:3: 
            {
            }

             after(grammarAccess.getIsParentConstraintRuleAccess().getIsParentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__IsParentConstraintRule__Group__1"
    // InternalDsl.g:1964:1: rule__IsParentConstraintRule__Group__1 : rule__IsParentConstraintRule__Group__1__Impl rule__IsParentConstraintRule__Group__2 ;
    public final void rule__IsParentConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1968:1: ( rule__IsParentConstraintRule__Group__1__Impl rule__IsParentConstraintRule__Group__2 )
            // InternalDsl.g:1969:2: rule__IsParentConstraintRule__Group__1__Impl rule__IsParentConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__IsParentConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__1"


    // $ANTLR start "rule__IsParentConstraintRule__Group__1__Impl"
    // InternalDsl.g:1976:1: rule__IsParentConstraintRule__Group__1__Impl : ( 'IsParent' ) ;
    public final void rule__IsParentConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1980:1: ( ( 'IsParent' ) )
            // InternalDsl.g:1981:1: ( 'IsParent' )
            {
            // InternalDsl.g:1981:1: ( 'IsParent' )
            // InternalDsl.g:1982:2: 'IsParent'
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getIsParentKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getIsParentConstraintRuleAccess().getIsParentKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__IsParentConstraintRule__Group__2"
    // InternalDsl.g:1991:1: rule__IsParentConstraintRule__Group__2 : rule__IsParentConstraintRule__Group__2__Impl rule__IsParentConstraintRule__Group__3 ;
    public final void rule__IsParentConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:1995:1: ( rule__IsParentConstraintRule__Group__2__Impl rule__IsParentConstraintRule__Group__3 )
            // InternalDsl.g:1996:2: rule__IsParentConstraintRule__Group__2__Impl rule__IsParentConstraintRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IsParentConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__2"


    // $ANTLR start "rule__IsParentConstraintRule__Group__2__Impl"
    // InternalDsl.g:2003:1: rule__IsParentConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__IsParentConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2007:1: ( ( '(' ) )
            // InternalDsl.g:2008:1: ( '(' )
            {
            // InternalDsl.g:2008:1: ( '(' )
            // InternalDsl.g:2009:2: '('
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getIsParentConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__IsParentConstraintRule__Group__3"
    // InternalDsl.g:2018:1: rule__IsParentConstraintRule__Group__3 : rule__IsParentConstraintRule__Group__3__Impl rule__IsParentConstraintRule__Group__4 ;
    public final void rule__IsParentConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2022:1: ( rule__IsParentConstraintRule__Group__3__Impl rule__IsParentConstraintRule__Group__4 )
            // InternalDsl.g:2023:2: rule__IsParentConstraintRule__Group__3__Impl rule__IsParentConstraintRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__IsParentConstraintRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__3"


    // $ANTLR start "rule__IsParentConstraintRule__Group__3__Impl"
    // InternalDsl.g:2030:1: rule__IsParentConstraintRule__Group__3__Impl : ( ( rule__IsParentConstraintRule__TypeAssignment_3 ) ) ;
    public final void rule__IsParentConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2034:1: ( ( ( rule__IsParentConstraintRule__TypeAssignment_3 ) ) )
            // InternalDsl.g:2035:1: ( ( rule__IsParentConstraintRule__TypeAssignment_3 ) )
            {
            // InternalDsl.g:2035:1: ( ( rule__IsParentConstraintRule__TypeAssignment_3 ) )
            // InternalDsl.g:2036:2: ( rule__IsParentConstraintRule__TypeAssignment_3 )
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getTypeAssignment_3()); 
            // InternalDsl.g:2037:2: ( rule__IsParentConstraintRule__TypeAssignment_3 )
            // InternalDsl.g:2037:3: rule__IsParentConstraintRule__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIsParentConstraintRuleAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__IsParentConstraintRule__Group__4"
    // InternalDsl.g:2045:1: rule__IsParentConstraintRule__Group__4 : rule__IsParentConstraintRule__Group__4__Impl ;
    public final void rule__IsParentConstraintRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2049:1: ( rule__IsParentConstraintRule__Group__4__Impl )
            // InternalDsl.g:2050:2: rule__IsParentConstraintRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsParentConstraintRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__4"


    // $ANTLR start "rule__IsParentConstraintRule__Group__4__Impl"
    // InternalDsl.g:2056:1: rule__IsParentConstraintRule__Group__4__Impl : ( ')' ) ;
    public final void rule__IsParentConstraintRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2060:1: ( ( ')' ) )
            // InternalDsl.g:2061:1: ( ')' )
            {
            // InternalDsl.g:2061:1: ( ')' )
            // InternalDsl.g:2062:2: ')'
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getRightParenthesisKeyword_4()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getIsParentConstraintRuleAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__Group__4__Impl"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__0"
    // InternalDsl.g:2072:1: rule__IsSourceTypeConstraintRule__Group__0 : rule__IsSourceTypeConstraintRule__Group__0__Impl rule__IsSourceTypeConstraintRule__Group__1 ;
    public final void rule__IsSourceTypeConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2076:1: ( rule__IsSourceTypeConstraintRule__Group__0__Impl rule__IsSourceTypeConstraintRule__Group__1 )
            // InternalDsl.g:2077:2: rule__IsSourceTypeConstraintRule__Group__0__Impl rule__IsSourceTypeConstraintRule__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__IsSourceTypeConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__0"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__0__Impl"
    // InternalDsl.g:2084:1: rule__IsSourceTypeConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__IsSourceTypeConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2088:1: ( ( () ) )
            // InternalDsl.g:2089:1: ( () )
            {
            // InternalDsl.g:2089:1: ( () )
            // InternalDsl.g:2090:2: ()
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getIsSourceTypeAction_0()); 
            // InternalDsl.g:2091:2: ()
            // InternalDsl.g:2091:3: 
            {
            }

             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getIsSourceTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__1"
    // InternalDsl.g:2099:1: rule__IsSourceTypeConstraintRule__Group__1 : rule__IsSourceTypeConstraintRule__Group__1__Impl rule__IsSourceTypeConstraintRule__Group__2 ;
    public final void rule__IsSourceTypeConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2103:1: ( rule__IsSourceTypeConstraintRule__Group__1__Impl rule__IsSourceTypeConstraintRule__Group__2 )
            // InternalDsl.g:2104:2: rule__IsSourceTypeConstraintRule__Group__1__Impl rule__IsSourceTypeConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__IsSourceTypeConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__1"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__1__Impl"
    // InternalDsl.g:2111:1: rule__IsSourceTypeConstraintRule__Group__1__Impl : ( 'IsSourceType' ) ;
    public final void rule__IsSourceTypeConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2115:1: ( ( 'IsSourceType' ) )
            // InternalDsl.g:2116:1: ( 'IsSourceType' )
            {
            // InternalDsl.g:2116:1: ( 'IsSourceType' )
            // InternalDsl.g:2117:2: 'IsSourceType'
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getIsSourceTypeKeyword_1()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getIsSourceTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__2"
    // InternalDsl.g:2126:1: rule__IsSourceTypeConstraintRule__Group__2 : rule__IsSourceTypeConstraintRule__Group__2__Impl rule__IsSourceTypeConstraintRule__Group__3 ;
    public final void rule__IsSourceTypeConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2130:1: ( rule__IsSourceTypeConstraintRule__Group__2__Impl rule__IsSourceTypeConstraintRule__Group__3 )
            // InternalDsl.g:2131:2: rule__IsSourceTypeConstraintRule__Group__2__Impl rule__IsSourceTypeConstraintRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IsSourceTypeConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__2"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__2__Impl"
    // InternalDsl.g:2138:1: rule__IsSourceTypeConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__IsSourceTypeConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2142:1: ( ( '(' ) )
            // InternalDsl.g:2143:1: ( '(' )
            {
            // InternalDsl.g:2143:1: ( '(' )
            // InternalDsl.g:2144:2: '('
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__3"
    // InternalDsl.g:2153:1: rule__IsSourceTypeConstraintRule__Group__3 : rule__IsSourceTypeConstraintRule__Group__3__Impl rule__IsSourceTypeConstraintRule__Group__4 ;
    public final void rule__IsSourceTypeConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2157:1: ( rule__IsSourceTypeConstraintRule__Group__3__Impl rule__IsSourceTypeConstraintRule__Group__4 )
            // InternalDsl.g:2158:2: rule__IsSourceTypeConstraintRule__Group__3__Impl rule__IsSourceTypeConstraintRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__IsSourceTypeConstraintRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__3"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__3__Impl"
    // InternalDsl.g:2165:1: rule__IsSourceTypeConstraintRule__Group__3__Impl : ( ( rule__IsSourceTypeConstraintRule__TypeAssignment_3 ) ) ;
    public final void rule__IsSourceTypeConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2169:1: ( ( ( rule__IsSourceTypeConstraintRule__TypeAssignment_3 ) ) )
            // InternalDsl.g:2170:1: ( ( rule__IsSourceTypeConstraintRule__TypeAssignment_3 ) )
            {
            // InternalDsl.g:2170:1: ( ( rule__IsSourceTypeConstraintRule__TypeAssignment_3 ) )
            // InternalDsl.g:2171:2: ( rule__IsSourceTypeConstraintRule__TypeAssignment_3 )
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getTypeAssignment_3()); 
            // InternalDsl.g:2172:2: ( rule__IsSourceTypeConstraintRule__TypeAssignment_3 )
            // InternalDsl.g:2172:3: rule__IsSourceTypeConstraintRule__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__4"
    // InternalDsl.g:2180:1: rule__IsSourceTypeConstraintRule__Group__4 : rule__IsSourceTypeConstraintRule__Group__4__Impl ;
    public final void rule__IsSourceTypeConstraintRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2184:1: ( rule__IsSourceTypeConstraintRule__Group__4__Impl )
            // InternalDsl.g:2185:2: rule__IsSourceTypeConstraintRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsSourceTypeConstraintRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__4"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__Group__4__Impl"
    // InternalDsl.g:2191:1: rule__IsSourceTypeConstraintRule__Group__4__Impl : ( ')' ) ;
    public final void rule__IsSourceTypeConstraintRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2195:1: ( ( ')' ) )
            // InternalDsl.g:2196:1: ( ')' )
            {
            // InternalDsl.g:2196:1: ( ')' )
            // InternalDsl.g:2197:2: ')'
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getRightParenthesisKeyword_4()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__Group__4__Impl"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__0"
    // InternalDsl.g:2207:1: rule__IsTargetConstraintRule__Group__0 : rule__IsTargetConstraintRule__Group__0__Impl rule__IsTargetConstraintRule__Group__1 ;
    public final void rule__IsTargetConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2211:1: ( rule__IsTargetConstraintRule__Group__0__Impl rule__IsTargetConstraintRule__Group__1 )
            // InternalDsl.g:2212:2: rule__IsTargetConstraintRule__Group__0__Impl rule__IsTargetConstraintRule__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__IsTargetConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__0"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__0__Impl"
    // InternalDsl.g:2219:1: rule__IsTargetConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__IsTargetConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2223:1: ( ( () ) )
            // InternalDsl.g:2224:1: ( () )
            {
            // InternalDsl.g:2224:1: ( () )
            // InternalDsl.g:2225:2: ()
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getIsTargetAction_0()); 
            // InternalDsl.g:2226:2: ()
            // InternalDsl.g:2226:3: 
            {
            }

             after(grammarAccess.getIsTargetConstraintRuleAccess().getIsTargetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__1"
    // InternalDsl.g:2234:1: rule__IsTargetConstraintRule__Group__1 : rule__IsTargetConstraintRule__Group__1__Impl rule__IsTargetConstraintRule__Group__2 ;
    public final void rule__IsTargetConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2238:1: ( rule__IsTargetConstraintRule__Group__1__Impl rule__IsTargetConstraintRule__Group__2 )
            // InternalDsl.g:2239:2: rule__IsTargetConstraintRule__Group__1__Impl rule__IsTargetConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__IsTargetConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__1"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__1__Impl"
    // InternalDsl.g:2246:1: rule__IsTargetConstraintRule__Group__1__Impl : ( 'IsTarget' ) ;
    public final void rule__IsTargetConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2250:1: ( ( 'IsTarget' ) )
            // InternalDsl.g:2251:1: ( 'IsTarget' )
            {
            // InternalDsl.g:2251:1: ( 'IsTarget' )
            // InternalDsl.g:2252:2: 'IsTarget'
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getIsTargetKeyword_1()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getIsTargetConstraintRuleAccess().getIsTargetKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__2"
    // InternalDsl.g:2261:1: rule__IsTargetConstraintRule__Group__2 : rule__IsTargetConstraintRule__Group__2__Impl rule__IsTargetConstraintRule__Group__3 ;
    public final void rule__IsTargetConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2265:1: ( rule__IsTargetConstraintRule__Group__2__Impl rule__IsTargetConstraintRule__Group__3 )
            // InternalDsl.g:2266:2: rule__IsTargetConstraintRule__Group__2__Impl rule__IsTargetConstraintRule__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IsTargetConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__2"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__2__Impl"
    // InternalDsl.g:2273:1: rule__IsTargetConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__IsTargetConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2277:1: ( ( '(' ) )
            // InternalDsl.g:2278:1: ( '(' )
            {
            // InternalDsl.g:2278:1: ( '(' )
            // InternalDsl.g:2279:2: '('
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getIsTargetConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__3"
    // InternalDsl.g:2288:1: rule__IsTargetConstraintRule__Group__3 : rule__IsTargetConstraintRule__Group__3__Impl rule__IsTargetConstraintRule__Group__4 ;
    public final void rule__IsTargetConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2292:1: ( rule__IsTargetConstraintRule__Group__3__Impl rule__IsTargetConstraintRule__Group__4 )
            // InternalDsl.g:2293:2: rule__IsTargetConstraintRule__Group__3__Impl rule__IsTargetConstraintRule__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__IsTargetConstraintRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__3"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__3__Impl"
    // InternalDsl.g:2300:1: rule__IsTargetConstraintRule__Group__3__Impl : ( ( rule__IsTargetConstraintRule__TypeAssignment_3 ) ) ;
    public final void rule__IsTargetConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2304:1: ( ( ( rule__IsTargetConstraintRule__TypeAssignment_3 ) ) )
            // InternalDsl.g:2305:1: ( ( rule__IsTargetConstraintRule__TypeAssignment_3 ) )
            {
            // InternalDsl.g:2305:1: ( ( rule__IsTargetConstraintRule__TypeAssignment_3 ) )
            // InternalDsl.g:2306:2: ( rule__IsTargetConstraintRule__TypeAssignment_3 )
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getTypeAssignment_3()); 
            // InternalDsl.g:2307:2: ( rule__IsTargetConstraintRule__TypeAssignment_3 )
            // InternalDsl.g:2307:3: rule__IsTargetConstraintRule__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIsTargetConstraintRuleAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__4"
    // InternalDsl.g:2315:1: rule__IsTargetConstraintRule__Group__4 : rule__IsTargetConstraintRule__Group__4__Impl ;
    public final void rule__IsTargetConstraintRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2319:1: ( rule__IsTargetConstraintRule__Group__4__Impl )
            // InternalDsl.g:2320:2: rule__IsTargetConstraintRule__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsTargetConstraintRule__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__4"


    // $ANTLR start "rule__IsTargetConstraintRule__Group__4__Impl"
    // InternalDsl.g:2326:1: rule__IsTargetConstraintRule__Group__4__Impl : ( ')' ) ;
    public final void rule__IsTargetConstraintRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2330:1: ( ( ')' ) )
            // InternalDsl.g:2331:1: ( ')' )
            {
            // InternalDsl.g:2331:1: ( ')' )
            // InternalDsl.g:2332:2: ')'
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getRightParenthesisKeyword_4()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getIsTargetConstraintRuleAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__Group__4__Impl"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__0"
    // InternalDsl.g:2342:1: rule__InCompartmentConstraintRule__Group__0 : rule__InCompartmentConstraintRule__Group__0__Impl rule__InCompartmentConstraintRule__Group__1 ;
    public final void rule__InCompartmentConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2346:1: ( rule__InCompartmentConstraintRule__Group__0__Impl rule__InCompartmentConstraintRule__Group__1 )
            // InternalDsl.g:2347:2: rule__InCompartmentConstraintRule__Group__0__Impl rule__InCompartmentConstraintRule__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__InCompartmentConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InCompartmentConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__0"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__0__Impl"
    // InternalDsl.g:2354:1: rule__InCompartmentConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__InCompartmentConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2358:1: ( ( () ) )
            // InternalDsl.g:2359:1: ( () )
            {
            // InternalDsl.g:2359:1: ( () )
            // InternalDsl.g:2360:2: ()
            {
             before(grammarAccess.getInCompartmentConstraintRuleAccess().getInCompartmentAction_0()); 
            // InternalDsl.g:2361:2: ()
            // InternalDsl.g:2361:3: 
            {
            }

             after(grammarAccess.getInCompartmentConstraintRuleAccess().getInCompartmentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__1"
    // InternalDsl.g:2369:1: rule__InCompartmentConstraintRule__Group__1 : rule__InCompartmentConstraintRule__Group__1__Impl rule__InCompartmentConstraintRule__Group__2 ;
    public final void rule__InCompartmentConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2373:1: ( rule__InCompartmentConstraintRule__Group__1__Impl rule__InCompartmentConstraintRule__Group__2 )
            // InternalDsl.g:2374:2: rule__InCompartmentConstraintRule__Group__1__Impl rule__InCompartmentConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__InCompartmentConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InCompartmentConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__1"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__1__Impl"
    // InternalDsl.g:2381:1: rule__InCompartmentConstraintRule__Group__1__Impl : ( 'InCompartment' ) ;
    public final void rule__InCompartmentConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2385:1: ( ( 'InCompartment' ) )
            // InternalDsl.g:2386:1: ( 'InCompartment' )
            {
            // InternalDsl.g:2386:1: ( 'InCompartment' )
            // InternalDsl.g:2387:2: 'InCompartment'
            {
             before(grammarAccess.getInCompartmentConstraintRuleAccess().getInCompartmentKeyword_1()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getInCompartmentConstraintRuleAccess().getInCompartmentKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__2"
    // InternalDsl.g:2396:1: rule__InCompartmentConstraintRule__Group__2 : rule__InCompartmentConstraintRule__Group__2__Impl rule__InCompartmentConstraintRule__Group__3 ;
    public final void rule__InCompartmentConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2400:1: ( rule__InCompartmentConstraintRule__Group__2__Impl rule__InCompartmentConstraintRule__Group__3 )
            // InternalDsl.g:2401:2: rule__InCompartmentConstraintRule__Group__2__Impl rule__InCompartmentConstraintRule__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__InCompartmentConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InCompartmentConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__2"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__2__Impl"
    // InternalDsl.g:2408:1: rule__InCompartmentConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__InCompartmentConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2412:1: ( ( '(' ) )
            // InternalDsl.g:2413:1: ( '(' )
            {
            // InternalDsl.g:2413:1: ( '(' )
            // InternalDsl.g:2414:2: '('
            {
             before(grammarAccess.getInCompartmentConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getInCompartmentConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__3"
    // InternalDsl.g:2423:1: rule__InCompartmentConstraintRule__Group__3 : rule__InCompartmentConstraintRule__Group__3__Impl ;
    public final void rule__InCompartmentConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2427:1: ( rule__InCompartmentConstraintRule__Group__3__Impl )
            // InternalDsl.g:2428:2: rule__InCompartmentConstraintRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InCompartmentConstraintRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__3"


    // $ANTLR start "rule__InCompartmentConstraintRule__Group__3__Impl"
    // InternalDsl.g:2434:1: rule__InCompartmentConstraintRule__Group__3__Impl : ( ')' ) ;
    public final void rule__InCompartmentConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2438:1: ( ( ')' ) )
            // InternalDsl.g:2439:1: ( ')' )
            {
            // InternalDsl.g:2439:1: ( ')' )
            // InternalDsl.g:2440:2: ')'
            {
             before(grammarAccess.getInCompartmentConstraintRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getInCompartmentConstraintRuleAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InCompartmentConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__0"
    // InternalDsl.g:2450:1: rule__SourceEqualsTargetConstraintRule__Group__0 : rule__SourceEqualsTargetConstraintRule__Group__0__Impl rule__SourceEqualsTargetConstraintRule__Group__1 ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2454:1: ( rule__SourceEqualsTargetConstraintRule__Group__0__Impl rule__SourceEqualsTargetConstraintRule__Group__1 )
            // InternalDsl.g:2455:2: rule__SourceEqualsTargetConstraintRule__Group__0__Impl rule__SourceEqualsTargetConstraintRule__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__SourceEqualsTargetConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__0"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__0__Impl"
    // InternalDsl.g:2462:1: rule__SourceEqualsTargetConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2466:1: ( ( () ) )
            // InternalDsl.g:2467:1: ( () )
            {
            // InternalDsl.g:2467:1: ( () )
            // InternalDsl.g:2468:2: ()
            {
             before(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getSourceEqualsTargetAction_0()); 
            // InternalDsl.g:2469:2: ()
            // InternalDsl.g:2469:3: 
            {
            }

             after(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getSourceEqualsTargetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__1"
    // InternalDsl.g:2477:1: rule__SourceEqualsTargetConstraintRule__Group__1 : rule__SourceEqualsTargetConstraintRule__Group__1__Impl rule__SourceEqualsTargetConstraintRule__Group__2 ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2481:1: ( rule__SourceEqualsTargetConstraintRule__Group__1__Impl rule__SourceEqualsTargetConstraintRule__Group__2 )
            // InternalDsl.g:2482:2: rule__SourceEqualsTargetConstraintRule__Group__1__Impl rule__SourceEqualsTargetConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__SourceEqualsTargetConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__1"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__1__Impl"
    // InternalDsl.g:2489:1: rule__SourceEqualsTargetConstraintRule__Group__1__Impl : ( 'SourceEqualsTarget' ) ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2493:1: ( ( 'SourceEqualsTarget' ) )
            // InternalDsl.g:2494:1: ( 'SourceEqualsTarget' )
            {
            // InternalDsl.g:2494:1: ( 'SourceEqualsTarget' )
            // InternalDsl.g:2495:2: 'SourceEqualsTarget'
            {
             before(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getSourceEqualsTargetKeyword_1()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getSourceEqualsTargetKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__2"
    // InternalDsl.g:2504:1: rule__SourceEqualsTargetConstraintRule__Group__2 : rule__SourceEqualsTargetConstraintRule__Group__2__Impl rule__SourceEqualsTargetConstraintRule__Group__3 ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2508:1: ( rule__SourceEqualsTargetConstraintRule__Group__2__Impl rule__SourceEqualsTargetConstraintRule__Group__3 )
            // InternalDsl.g:2509:2: rule__SourceEqualsTargetConstraintRule__Group__2__Impl rule__SourceEqualsTargetConstraintRule__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__SourceEqualsTargetConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__2"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__2__Impl"
    // InternalDsl.g:2516:1: rule__SourceEqualsTargetConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2520:1: ( ( '(' ) )
            // InternalDsl.g:2521:1: ( '(' )
            {
            // InternalDsl.g:2521:1: ( '(' )
            // InternalDsl.g:2522:2: '('
            {
             before(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__3"
    // InternalDsl.g:2531:1: rule__SourceEqualsTargetConstraintRule__Group__3 : rule__SourceEqualsTargetConstraintRule__Group__3__Impl ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2535:1: ( rule__SourceEqualsTargetConstraintRule__Group__3__Impl )
            // InternalDsl.g:2536:2: rule__SourceEqualsTargetConstraintRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetConstraintRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__3"


    // $ANTLR start "rule__SourceEqualsTargetConstraintRule__Group__3__Impl"
    // InternalDsl.g:2542:1: rule__SourceEqualsTargetConstraintRule__Group__3__Impl : ( ')' ) ;
    public final void rule__SourceEqualsTargetConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2546:1: ( ( ')' ) )
            // InternalDsl.g:2547:1: ( ')' )
            {
            // InternalDsl.g:2547:1: ( ')' )
            // InternalDsl.g:2548:2: ')'
            {
             before(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getSourceEqualsTargetConstraintRuleAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__0"
    // InternalDsl.g:2558:1: rule__SourceEqualsTargetTypeConstraintRule__Group__0 : rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__1 ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2562:1: ( rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__1 )
            // InternalDsl.g:2563:2: rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetTypeConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__0"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl"
    // InternalDsl.g:2570:1: rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2574:1: ( ( () ) )
            // InternalDsl.g:2575:1: ( () )
            {
            // InternalDsl.g:2575:1: ( () )
            // InternalDsl.g:2576:2: ()
            {
             before(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getSourceEqualsTargetTypeAction_0()); 
            // InternalDsl.g:2577:2: ()
            // InternalDsl.g:2577:3: 
            {
            }

             after(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getSourceEqualsTargetTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__1"
    // InternalDsl.g:2585:1: rule__SourceEqualsTargetTypeConstraintRule__Group__1 : rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__2 ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2589:1: ( rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__2 )
            // InternalDsl.g:2590:2: rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetTypeConstraintRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__1"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl"
    // InternalDsl.g:2597:1: rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl : ( 'SourceEqualsTargetType' ) ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2601:1: ( ( 'SourceEqualsTargetType' ) )
            // InternalDsl.g:2602:1: ( 'SourceEqualsTargetType' )
            {
            // InternalDsl.g:2602:1: ( 'SourceEqualsTargetType' )
            // InternalDsl.g:2603:2: 'SourceEqualsTargetType'
            {
             before(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getSourceEqualsTargetTypeKeyword_1()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getSourceEqualsTargetTypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__2"
    // InternalDsl.g:2612:1: rule__SourceEqualsTargetTypeConstraintRule__Group__2 : rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__3 ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2616:1: ( rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__3 )
            // InternalDsl.g:2617:2: rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl rule__SourceEqualsTargetTypeConstraintRule__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetTypeConstraintRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__2"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl"
    // InternalDsl.g:2624:1: rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl : ( '(' ) ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2628:1: ( ( '(' ) )
            // InternalDsl.g:2629:1: ( '(' )
            {
            // InternalDsl.g:2629:1: ( '(' )
            // InternalDsl.g:2630:2: '('
            {
             before(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__2__Impl"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__3"
    // InternalDsl.g:2639:1: rule__SourceEqualsTargetTypeConstraintRule__Group__3 : rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2643:1: ( rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl )
            // InternalDsl.g:2644:2: rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__3"


    // $ANTLR start "rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl"
    // InternalDsl.g:2650:1: rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl : ( ')' ) ;
    public final void rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2654:1: ( ( ')' ) )
            // InternalDsl.g:2655:1: ( ')' )
            {
            // InternalDsl.g:2655:1: ( ')' )
            // InternalDsl.g:2656:2: ')'
            {
             before(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getRightParenthesisKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getSourceEqualsTargetTypeConstraintRuleAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceEqualsTargetTypeConstraintRule__Group__3__Impl"


    // $ANTLR start "rule__IsFeature__Group__0"
    // InternalDsl.g:2666:1: rule__IsFeature__Group__0 : rule__IsFeature__Group__0__Impl rule__IsFeature__Group__1 ;
    public final void rule__IsFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2670:1: ( rule__IsFeature__Group__0__Impl rule__IsFeature__Group__1 )
            // InternalDsl.g:2671:2: rule__IsFeature__Group__0__Impl rule__IsFeature__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__IsFeature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsFeature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsFeature__Group__0"


    // $ANTLR start "rule__IsFeature__Group__0__Impl"
    // InternalDsl.g:2678:1: rule__IsFeature__Group__0__Impl : ( () ) ;
    public final void rule__IsFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2682:1: ( ( () ) )
            // InternalDsl.g:2683:1: ( () )
            {
            // InternalDsl.g:2683:1: ( () )
            // InternalDsl.g:2684:2: ()
            {
             before(grammarAccess.getIsFeatureAccess().getIsFeatureAction_0()); 
            // InternalDsl.g:2685:2: ()
            // InternalDsl.g:2685:3: 
            {
            }

             after(grammarAccess.getIsFeatureAccess().getIsFeatureAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsFeature__Group__0__Impl"


    // $ANTLR start "rule__IsFeature__Group__1"
    // InternalDsl.g:2693:1: rule__IsFeature__Group__1 : rule__IsFeature__Group__1__Impl ;
    public final void rule__IsFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2697:1: ( rule__IsFeature__Group__1__Impl )
            // InternalDsl.g:2698:2: rule__IsFeature__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsFeature__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsFeature__Group__1"


    // $ANTLR start "rule__IsFeature__Group__1__Impl"
    // InternalDsl.g:2704:1: rule__IsFeature__Group__1__Impl : ( ( rule__IsFeature__FeatureNameAssignment_1 ) ) ;
    public final void rule__IsFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2708:1: ( ( ( rule__IsFeature__FeatureNameAssignment_1 ) ) )
            // InternalDsl.g:2709:1: ( ( rule__IsFeature__FeatureNameAssignment_1 ) )
            {
            // InternalDsl.g:2709:1: ( ( rule__IsFeature__FeatureNameAssignment_1 ) )
            // InternalDsl.g:2710:2: ( rule__IsFeature__FeatureNameAssignment_1 )
            {
             before(grammarAccess.getIsFeatureAccess().getFeatureNameAssignment_1()); 
            // InternalDsl.g:2711:2: ( rule__IsFeature__FeatureNameAssignment_1 )
            // InternalDsl.g:2711:3: rule__IsFeature__FeatureNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IsFeature__FeatureNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIsFeatureAccess().getFeatureNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsFeature__Group__1__Impl"


    // $ANTLR start "rule__TrueFeatureRule__Group__0"
    // InternalDsl.g:2720:1: rule__TrueFeatureRule__Group__0 : rule__TrueFeatureRule__Group__0__Impl rule__TrueFeatureRule__Group__1 ;
    public final void rule__TrueFeatureRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2724:1: ( rule__TrueFeatureRule__Group__0__Impl rule__TrueFeatureRule__Group__1 )
            // InternalDsl.g:2725:2: rule__TrueFeatureRule__Group__0__Impl rule__TrueFeatureRule__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__TrueFeatureRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueFeatureRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFeatureRule__Group__0"


    // $ANTLR start "rule__TrueFeatureRule__Group__0__Impl"
    // InternalDsl.g:2732:1: rule__TrueFeatureRule__Group__0__Impl : ( () ) ;
    public final void rule__TrueFeatureRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2736:1: ( ( () ) )
            // InternalDsl.g:2737:1: ( () )
            {
            // InternalDsl.g:2737:1: ( () )
            // InternalDsl.g:2738:2: ()
            {
             before(grammarAccess.getTrueFeatureRuleAccess().getTrueFeatureRuleAction_0()); 
            // InternalDsl.g:2739:2: ()
            // InternalDsl.g:2739:3: 
            {
            }

             after(grammarAccess.getTrueFeatureRuleAccess().getTrueFeatureRuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFeatureRule__Group__0__Impl"


    // $ANTLR start "rule__TrueFeatureRule__Group__1"
    // InternalDsl.g:2747:1: rule__TrueFeatureRule__Group__1 : rule__TrueFeatureRule__Group__1__Impl ;
    public final void rule__TrueFeatureRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2751:1: ( rule__TrueFeatureRule__Group__1__Impl )
            // InternalDsl.g:2752:2: rule__TrueFeatureRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrueFeatureRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFeatureRule__Group__1"


    // $ANTLR start "rule__TrueFeatureRule__Group__1__Impl"
    // InternalDsl.g:2758:1: rule__TrueFeatureRule__Group__1__Impl : ( 'true' ) ;
    public final void rule__TrueFeatureRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2762:1: ( ( 'true' ) )
            // InternalDsl.g:2763:1: ( 'true' )
            {
            // InternalDsl.g:2763:1: ( 'true' )
            // InternalDsl.g:2764:2: 'true'
            {
             before(grammarAccess.getTrueFeatureRuleAccess().getTrueKeyword_1()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getTrueFeatureRuleAccess().getTrueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueFeatureRule__Group__1__Impl"


    // $ANTLR start "rule__TrueConstraintRule__Group__0"
    // InternalDsl.g:2774:1: rule__TrueConstraintRule__Group__0 : rule__TrueConstraintRule__Group__0__Impl rule__TrueConstraintRule__Group__1 ;
    public final void rule__TrueConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2778:1: ( rule__TrueConstraintRule__Group__0__Impl rule__TrueConstraintRule__Group__1 )
            // InternalDsl.g:2779:2: rule__TrueConstraintRule__Group__0__Impl rule__TrueConstraintRule__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__TrueConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueConstraintRule__Group__0"


    // $ANTLR start "rule__TrueConstraintRule__Group__0__Impl"
    // InternalDsl.g:2786:1: rule__TrueConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__TrueConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2790:1: ( ( () ) )
            // InternalDsl.g:2791:1: ( () )
            {
            // InternalDsl.g:2791:1: ( () )
            // InternalDsl.g:2792:2: ()
            {
             before(grammarAccess.getTrueConstraintRuleAccess().getTrueConstraintRuleAction_0()); 
            // InternalDsl.g:2793:2: ()
            // InternalDsl.g:2793:3: 
            {
            }

             after(grammarAccess.getTrueConstraintRuleAccess().getTrueConstraintRuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__TrueConstraintRule__Group__1"
    // InternalDsl.g:2801:1: rule__TrueConstraintRule__Group__1 : rule__TrueConstraintRule__Group__1__Impl ;
    public final void rule__TrueConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2805:1: ( rule__TrueConstraintRule__Group__1__Impl )
            // InternalDsl.g:2806:2: rule__TrueConstraintRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrueConstraintRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueConstraintRule__Group__1"


    // $ANTLR start "rule__TrueConstraintRule__Group__1__Impl"
    // InternalDsl.g:2812:1: rule__TrueConstraintRule__Group__1__Impl : ( 'true' ) ;
    public final void rule__TrueConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2816:1: ( ( 'true' ) )
            // InternalDsl.g:2817:1: ( 'true' )
            {
            // InternalDsl.g:2817:1: ( 'true' )
            // InternalDsl.g:2818:2: 'true'
            {
             before(grammarAccess.getTrueConstraintRuleAccess().getTrueKeyword_1()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getTrueConstraintRuleAccess().getTrueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__FalseFeatureRule__Group__0"
    // InternalDsl.g:2828:1: rule__FalseFeatureRule__Group__0 : rule__FalseFeatureRule__Group__0__Impl rule__FalseFeatureRule__Group__1 ;
    public final void rule__FalseFeatureRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2832:1: ( rule__FalseFeatureRule__Group__0__Impl rule__FalseFeatureRule__Group__1 )
            // InternalDsl.g:2833:2: rule__FalseFeatureRule__Group__0__Impl rule__FalseFeatureRule__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__FalseFeatureRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FalseFeatureRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseFeatureRule__Group__0"


    // $ANTLR start "rule__FalseFeatureRule__Group__0__Impl"
    // InternalDsl.g:2840:1: rule__FalseFeatureRule__Group__0__Impl : ( () ) ;
    public final void rule__FalseFeatureRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2844:1: ( ( () ) )
            // InternalDsl.g:2845:1: ( () )
            {
            // InternalDsl.g:2845:1: ( () )
            // InternalDsl.g:2846:2: ()
            {
             before(grammarAccess.getFalseFeatureRuleAccess().getFalseFeatureRuleAction_0()); 
            // InternalDsl.g:2847:2: ()
            // InternalDsl.g:2847:3: 
            {
            }

             after(grammarAccess.getFalseFeatureRuleAccess().getFalseFeatureRuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseFeatureRule__Group__0__Impl"


    // $ANTLR start "rule__FalseFeatureRule__Group__1"
    // InternalDsl.g:2855:1: rule__FalseFeatureRule__Group__1 : rule__FalseFeatureRule__Group__1__Impl ;
    public final void rule__FalseFeatureRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2859:1: ( rule__FalseFeatureRule__Group__1__Impl )
            // InternalDsl.g:2860:2: rule__FalseFeatureRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FalseFeatureRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseFeatureRule__Group__1"


    // $ANTLR start "rule__FalseFeatureRule__Group__1__Impl"
    // InternalDsl.g:2866:1: rule__FalseFeatureRule__Group__1__Impl : ( 'false' ) ;
    public final void rule__FalseFeatureRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2870:1: ( ( 'false' ) )
            // InternalDsl.g:2871:1: ( 'false' )
            {
            // InternalDsl.g:2871:1: ( 'false' )
            // InternalDsl.g:2872:2: 'false'
            {
             before(grammarAccess.getFalseFeatureRuleAccess().getFalseKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getFalseFeatureRuleAccess().getFalseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseFeatureRule__Group__1__Impl"


    // $ANTLR start "rule__FalseConstraintRule__Group__0"
    // InternalDsl.g:2882:1: rule__FalseConstraintRule__Group__0 : rule__FalseConstraintRule__Group__0__Impl rule__FalseConstraintRule__Group__1 ;
    public final void rule__FalseConstraintRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2886:1: ( rule__FalseConstraintRule__Group__0__Impl rule__FalseConstraintRule__Group__1 )
            // InternalDsl.g:2887:2: rule__FalseConstraintRule__Group__0__Impl rule__FalseConstraintRule__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__FalseConstraintRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FalseConstraintRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseConstraintRule__Group__0"


    // $ANTLR start "rule__FalseConstraintRule__Group__0__Impl"
    // InternalDsl.g:2894:1: rule__FalseConstraintRule__Group__0__Impl : ( () ) ;
    public final void rule__FalseConstraintRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2898:1: ( ( () ) )
            // InternalDsl.g:2899:1: ( () )
            {
            // InternalDsl.g:2899:1: ( () )
            // InternalDsl.g:2900:2: ()
            {
             before(grammarAccess.getFalseConstraintRuleAccess().getFalseConstraintRuleAction_0()); 
            // InternalDsl.g:2901:2: ()
            // InternalDsl.g:2901:3: 
            {
            }

             after(grammarAccess.getFalseConstraintRuleAccess().getFalseConstraintRuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseConstraintRule__Group__0__Impl"


    // $ANTLR start "rule__FalseConstraintRule__Group__1"
    // InternalDsl.g:2909:1: rule__FalseConstraintRule__Group__1 : rule__FalseConstraintRule__Group__1__Impl ;
    public final void rule__FalseConstraintRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2913:1: ( rule__FalseConstraintRule__Group__1__Impl )
            // InternalDsl.g:2914:2: rule__FalseConstraintRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FalseConstraintRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseConstraintRule__Group__1"


    // $ANTLR start "rule__FalseConstraintRule__Group__1__Impl"
    // InternalDsl.g:2920:1: rule__FalseConstraintRule__Group__1__Impl : ( 'false' ) ;
    public final void rule__FalseConstraintRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2924:1: ( ( 'false' ) )
            // InternalDsl.g:2925:1: ( 'false' )
            {
            // InternalDsl.g:2925:1: ( 'false' )
            // InternalDsl.g:2926:2: 'false'
            {
             before(grammarAccess.getFalseConstraintRuleAccess().getFalseKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getFalseConstraintRuleAccess().getFalseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseConstraintRule__Group__1__Impl"


    // $ANTLR start "rule__OrFeature__Group__0"
    // InternalDsl.g:2936:1: rule__OrFeature__Group__0 : rule__OrFeature__Group__0__Impl rule__OrFeature__Group__1 ;
    public final void rule__OrFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2940:1: ( rule__OrFeature__Group__0__Impl rule__OrFeature__Group__1 )
            // InternalDsl.g:2941:2: rule__OrFeature__Group__0__Impl rule__OrFeature__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__OrFeature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrFeature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group__0"


    // $ANTLR start "rule__OrFeature__Group__0__Impl"
    // InternalDsl.g:2948:1: rule__OrFeature__Group__0__Impl : ( ruleAndFeature ) ;
    public final void rule__OrFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2952:1: ( ( ruleAndFeature ) )
            // InternalDsl.g:2953:1: ( ruleAndFeature )
            {
            // InternalDsl.g:2953:1: ( ruleAndFeature )
            // InternalDsl.g:2954:2: ruleAndFeature
            {
             before(grammarAccess.getOrFeatureAccess().getAndFeatureParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndFeature();

            state._fsp--;

             after(grammarAccess.getOrFeatureAccess().getAndFeatureParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group__0__Impl"


    // $ANTLR start "rule__OrFeature__Group__1"
    // InternalDsl.g:2963:1: rule__OrFeature__Group__1 : rule__OrFeature__Group__1__Impl ;
    public final void rule__OrFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2967:1: ( rule__OrFeature__Group__1__Impl )
            // InternalDsl.g:2968:2: rule__OrFeature__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrFeature__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group__1"


    // $ANTLR start "rule__OrFeature__Group__1__Impl"
    // InternalDsl.g:2974:1: rule__OrFeature__Group__1__Impl : ( ( rule__OrFeature__Group_1__0 )* ) ;
    public final void rule__OrFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2978:1: ( ( ( rule__OrFeature__Group_1__0 )* ) )
            // InternalDsl.g:2979:1: ( ( rule__OrFeature__Group_1__0 )* )
            {
            // InternalDsl.g:2979:1: ( ( rule__OrFeature__Group_1__0 )* )
            // InternalDsl.g:2980:2: ( rule__OrFeature__Group_1__0 )*
            {
             before(grammarAccess.getOrFeatureAccess().getGroup_1()); 
            // InternalDsl.g:2981:2: ( rule__OrFeature__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==90) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDsl.g:2981:3: rule__OrFeature__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__OrFeature__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getOrFeatureAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group__1__Impl"


    // $ANTLR start "rule__OrFeature__Group_1__0"
    // InternalDsl.g:2990:1: rule__OrFeature__Group_1__0 : rule__OrFeature__Group_1__0__Impl rule__OrFeature__Group_1__1 ;
    public final void rule__OrFeature__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:2994:1: ( rule__OrFeature__Group_1__0__Impl rule__OrFeature__Group_1__1 )
            // InternalDsl.g:2995:2: rule__OrFeature__Group_1__0__Impl rule__OrFeature__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__OrFeature__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrFeature__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group_1__0"


    // $ANTLR start "rule__OrFeature__Group_1__0__Impl"
    // InternalDsl.g:3002:1: rule__OrFeature__Group_1__0__Impl : ( () ) ;
    public final void rule__OrFeature__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3006:1: ( ( () ) )
            // InternalDsl.g:3007:1: ( () )
            {
            // InternalDsl.g:3007:1: ( () )
            // InternalDsl.g:3008:2: ()
            {
             before(grammarAccess.getOrFeatureAccess().getOrFeatureRuleRulesAction_1_0()); 
            // InternalDsl.g:3009:2: ()
            // InternalDsl.g:3009:3: 
            {
            }

             after(grammarAccess.getOrFeatureAccess().getOrFeatureRuleRulesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group_1__0__Impl"


    // $ANTLR start "rule__OrFeature__Group_1__1"
    // InternalDsl.g:3017:1: rule__OrFeature__Group_1__1 : rule__OrFeature__Group_1__1__Impl rule__OrFeature__Group_1__2 ;
    public final void rule__OrFeature__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3021:1: ( rule__OrFeature__Group_1__1__Impl rule__OrFeature__Group_1__2 )
            // InternalDsl.g:3022:2: rule__OrFeature__Group_1__1__Impl rule__OrFeature__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__OrFeature__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrFeature__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group_1__1"


    // $ANTLR start "rule__OrFeature__Group_1__1__Impl"
    // InternalDsl.g:3029:1: rule__OrFeature__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__OrFeature__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3033:1: ( ( 'or' ) )
            // InternalDsl.g:3034:1: ( 'or' )
            {
            // InternalDsl.g:3034:1: ( 'or' )
            // InternalDsl.g:3035:2: 'or'
            {
             before(grammarAccess.getOrFeatureAccess().getOrKeyword_1_1()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getOrFeatureAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group_1__1__Impl"


    // $ANTLR start "rule__OrFeature__Group_1__2"
    // InternalDsl.g:3044:1: rule__OrFeature__Group_1__2 : rule__OrFeature__Group_1__2__Impl ;
    public final void rule__OrFeature__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3048:1: ( rule__OrFeature__Group_1__2__Impl )
            // InternalDsl.g:3049:2: rule__OrFeature__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrFeature__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group_1__2"


    // $ANTLR start "rule__OrFeature__Group_1__2__Impl"
    // InternalDsl.g:3055:1: rule__OrFeature__Group_1__2__Impl : ( ( rule__OrFeature__RulesAssignment_1_2 ) ) ;
    public final void rule__OrFeature__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3059:1: ( ( ( rule__OrFeature__RulesAssignment_1_2 ) ) )
            // InternalDsl.g:3060:1: ( ( rule__OrFeature__RulesAssignment_1_2 ) )
            {
            // InternalDsl.g:3060:1: ( ( rule__OrFeature__RulesAssignment_1_2 ) )
            // InternalDsl.g:3061:2: ( rule__OrFeature__RulesAssignment_1_2 )
            {
             before(grammarAccess.getOrFeatureAccess().getRulesAssignment_1_2()); 
            // InternalDsl.g:3062:2: ( rule__OrFeature__RulesAssignment_1_2 )
            // InternalDsl.g:3062:3: rule__OrFeature__RulesAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrFeature__RulesAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrFeatureAccess().getRulesAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__Group_1__2__Impl"


    // $ANTLR start "rule__AndFeature__Group__0"
    // InternalDsl.g:3071:1: rule__AndFeature__Group__0 : rule__AndFeature__Group__0__Impl rule__AndFeature__Group__1 ;
    public final void rule__AndFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3075:1: ( rule__AndFeature__Group__0__Impl rule__AndFeature__Group__1 )
            // InternalDsl.g:3076:2: rule__AndFeature__Group__0__Impl rule__AndFeature__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__AndFeature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndFeature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group__0"


    // $ANTLR start "rule__AndFeature__Group__0__Impl"
    // InternalDsl.g:3083:1: rule__AndFeature__Group__0__Impl : ( ruleNotFeatureExpression ) ;
    public final void rule__AndFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3087:1: ( ( ruleNotFeatureExpression ) )
            // InternalDsl.g:3088:1: ( ruleNotFeatureExpression )
            {
            // InternalDsl.g:3088:1: ( ruleNotFeatureExpression )
            // InternalDsl.g:3089:2: ruleNotFeatureExpression
            {
             before(grammarAccess.getAndFeatureAccess().getNotFeatureExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleNotFeatureExpression();

            state._fsp--;

             after(grammarAccess.getAndFeatureAccess().getNotFeatureExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group__0__Impl"


    // $ANTLR start "rule__AndFeature__Group__1"
    // InternalDsl.g:3098:1: rule__AndFeature__Group__1 : rule__AndFeature__Group__1__Impl ;
    public final void rule__AndFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3102:1: ( rule__AndFeature__Group__1__Impl )
            // InternalDsl.g:3103:2: rule__AndFeature__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndFeature__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group__1"


    // $ANTLR start "rule__AndFeature__Group__1__Impl"
    // InternalDsl.g:3109:1: rule__AndFeature__Group__1__Impl : ( ( rule__AndFeature__Group_1__0 )* ) ;
    public final void rule__AndFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3113:1: ( ( ( rule__AndFeature__Group_1__0 )* ) )
            // InternalDsl.g:3114:1: ( ( rule__AndFeature__Group_1__0 )* )
            {
            // InternalDsl.g:3114:1: ( ( rule__AndFeature__Group_1__0 )* )
            // InternalDsl.g:3115:2: ( rule__AndFeature__Group_1__0 )*
            {
             before(grammarAccess.getAndFeatureAccess().getGroup_1()); 
            // InternalDsl.g:3116:2: ( rule__AndFeature__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==91) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDsl.g:3116:3: rule__AndFeature__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__AndFeature__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getAndFeatureAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group__1__Impl"


    // $ANTLR start "rule__AndFeature__Group_1__0"
    // InternalDsl.g:3125:1: rule__AndFeature__Group_1__0 : rule__AndFeature__Group_1__0__Impl rule__AndFeature__Group_1__1 ;
    public final void rule__AndFeature__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3129:1: ( rule__AndFeature__Group_1__0__Impl rule__AndFeature__Group_1__1 )
            // InternalDsl.g:3130:2: rule__AndFeature__Group_1__0__Impl rule__AndFeature__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__AndFeature__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndFeature__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group_1__0"


    // $ANTLR start "rule__AndFeature__Group_1__0__Impl"
    // InternalDsl.g:3137:1: rule__AndFeature__Group_1__0__Impl : ( () ) ;
    public final void rule__AndFeature__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3141:1: ( ( () ) )
            // InternalDsl.g:3142:1: ( () )
            {
            // InternalDsl.g:3142:1: ( () )
            // InternalDsl.g:3143:2: ()
            {
             before(grammarAccess.getAndFeatureAccess().getAndFeatureRuleRulesAction_1_0()); 
            // InternalDsl.g:3144:2: ()
            // InternalDsl.g:3144:3: 
            {
            }

             after(grammarAccess.getAndFeatureAccess().getAndFeatureRuleRulesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group_1__0__Impl"


    // $ANTLR start "rule__AndFeature__Group_1__1"
    // InternalDsl.g:3152:1: rule__AndFeature__Group_1__1 : rule__AndFeature__Group_1__1__Impl rule__AndFeature__Group_1__2 ;
    public final void rule__AndFeature__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3156:1: ( rule__AndFeature__Group_1__1__Impl rule__AndFeature__Group_1__2 )
            // InternalDsl.g:3157:2: rule__AndFeature__Group_1__1__Impl rule__AndFeature__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__AndFeature__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndFeature__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group_1__1"


    // $ANTLR start "rule__AndFeature__Group_1__1__Impl"
    // InternalDsl.g:3164:1: rule__AndFeature__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__AndFeature__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3168:1: ( ( 'and' ) )
            // InternalDsl.g:3169:1: ( 'and' )
            {
            // InternalDsl.g:3169:1: ( 'and' )
            // InternalDsl.g:3170:2: 'and'
            {
             before(grammarAccess.getAndFeatureAccess().getAndKeyword_1_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getAndFeatureAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group_1__1__Impl"


    // $ANTLR start "rule__AndFeature__Group_1__2"
    // InternalDsl.g:3179:1: rule__AndFeature__Group_1__2 : rule__AndFeature__Group_1__2__Impl ;
    public final void rule__AndFeature__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3183:1: ( rule__AndFeature__Group_1__2__Impl )
            // InternalDsl.g:3184:2: rule__AndFeature__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndFeature__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group_1__2"


    // $ANTLR start "rule__AndFeature__Group_1__2__Impl"
    // InternalDsl.g:3190:1: rule__AndFeature__Group_1__2__Impl : ( ( rule__AndFeature__RulesAssignment_1_2 ) ) ;
    public final void rule__AndFeature__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3194:1: ( ( ( rule__AndFeature__RulesAssignment_1_2 ) ) )
            // InternalDsl.g:3195:1: ( ( rule__AndFeature__RulesAssignment_1_2 ) )
            {
            // InternalDsl.g:3195:1: ( ( rule__AndFeature__RulesAssignment_1_2 ) )
            // InternalDsl.g:3196:2: ( rule__AndFeature__RulesAssignment_1_2 )
            {
             before(grammarAccess.getAndFeatureAccess().getRulesAssignment_1_2()); 
            // InternalDsl.g:3197:2: ( rule__AndFeature__RulesAssignment_1_2 )
            // InternalDsl.g:3197:3: rule__AndFeature__RulesAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndFeature__RulesAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndFeatureAccess().getRulesAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__Group_1__2__Impl"


    // $ANTLR start "rule__NotFeatureExpression__Group_1__0"
    // InternalDsl.g:3206:1: rule__NotFeatureExpression__Group_1__0 : rule__NotFeatureExpression__Group_1__0__Impl rule__NotFeatureExpression__Group_1__1 ;
    public final void rule__NotFeatureExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3210:1: ( rule__NotFeatureExpression__Group_1__0__Impl rule__NotFeatureExpression__Group_1__1 )
            // InternalDsl.g:3211:2: rule__NotFeatureExpression__Group_1__0__Impl rule__NotFeatureExpression__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__NotFeatureExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotFeatureExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Group_1__0"


    // $ANTLR start "rule__NotFeatureExpression__Group_1__0__Impl"
    // InternalDsl.g:3218:1: rule__NotFeatureExpression__Group_1__0__Impl : ( '!' ) ;
    public final void rule__NotFeatureExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3222:1: ( ( '!' ) )
            // InternalDsl.g:3223:1: ( '!' )
            {
            // InternalDsl.g:3223:1: ( '!' )
            // InternalDsl.g:3224:2: '!'
            {
             before(grammarAccess.getNotFeatureExpressionAccess().getExclamationMarkKeyword_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getNotFeatureExpressionAccess().getExclamationMarkKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NotFeatureExpression__Group_1__1"
    // InternalDsl.g:3233:1: rule__NotFeatureExpression__Group_1__1 : rule__NotFeatureExpression__Group_1__1__Impl rule__NotFeatureExpression__Group_1__2 ;
    public final void rule__NotFeatureExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3237:1: ( rule__NotFeatureExpression__Group_1__1__Impl rule__NotFeatureExpression__Group_1__2 )
            // InternalDsl.g:3238:2: rule__NotFeatureExpression__Group_1__1__Impl rule__NotFeatureExpression__Group_1__2
            {
            pushFollow(FOLLOW_28);
            rule__NotFeatureExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotFeatureExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Group_1__1"


    // $ANTLR start "rule__NotFeatureExpression__Group_1__1__Impl"
    // InternalDsl.g:3245:1: rule__NotFeatureExpression__Group_1__1__Impl : ( () ) ;
    public final void rule__NotFeatureExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3249:1: ( ( () ) )
            // InternalDsl.g:3250:1: ( () )
            {
            // InternalDsl.g:3250:1: ( () )
            // InternalDsl.g:3251:2: ()
            {
             before(grammarAccess.getNotFeatureExpressionAccess().getNotFeatureRuleAction_1_1()); 
            // InternalDsl.g:3252:2: ()
            // InternalDsl.g:3252:3: 
            {
            }

             after(grammarAccess.getNotFeatureExpressionAccess().getNotFeatureRuleAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Group_1__1__Impl"


    // $ANTLR start "rule__NotFeatureExpression__Group_1__2"
    // InternalDsl.g:3260:1: rule__NotFeatureExpression__Group_1__2 : rule__NotFeatureExpression__Group_1__2__Impl ;
    public final void rule__NotFeatureExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3264:1: ( rule__NotFeatureExpression__Group_1__2__Impl )
            // InternalDsl.g:3265:2: rule__NotFeatureExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NotFeatureExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Group_1__2"


    // $ANTLR start "rule__NotFeatureExpression__Group_1__2__Impl"
    // InternalDsl.g:3271:1: rule__NotFeatureExpression__Group_1__2__Impl : ( ( rule__NotFeatureExpression__RuleAssignment_1_2 ) ) ;
    public final void rule__NotFeatureExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3275:1: ( ( ( rule__NotFeatureExpression__RuleAssignment_1_2 ) ) )
            // InternalDsl.g:3276:1: ( ( rule__NotFeatureExpression__RuleAssignment_1_2 ) )
            {
            // InternalDsl.g:3276:1: ( ( rule__NotFeatureExpression__RuleAssignment_1_2 ) )
            // InternalDsl.g:3277:2: ( rule__NotFeatureExpression__RuleAssignment_1_2 )
            {
             before(grammarAccess.getNotFeatureExpressionAccess().getRuleAssignment_1_2()); 
            // InternalDsl.g:3278:2: ( rule__NotFeatureExpression__RuleAssignment_1_2 )
            // InternalDsl.g:3278:3: rule__NotFeatureExpression__RuleAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__NotFeatureExpression__RuleAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNotFeatureExpressionAccess().getRuleAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__Group_1__2__Impl"


    // $ANTLR start "rule__PrimaryFeature__Group_1__0"
    // InternalDsl.g:3287:1: rule__PrimaryFeature__Group_1__0 : rule__PrimaryFeature__Group_1__0__Impl rule__PrimaryFeature__Group_1__1 ;
    public final void rule__PrimaryFeature__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3291:1: ( rule__PrimaryFeature__Group_1__0__Impl rule__PrimaryFeature__Group_1__1 )
            // InternalDsl.g:3292:2: rule__PrimaryFeature__Group_1__0__Impl rule__PrimaryFeature__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__PrimaryFeature__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryFeature__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Group_1__0"


    // $ANTLR start "rule__PrimaryFeature__Group_1__0__Impl"
    // InternalDsl.g:3299:1: rule__PrimaryFeature__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryFeature__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3303:1: ( ( '(' ) )
            // InternalDsl.g:3304:1: ( '(' )
            {
            // InternalDsl.g:3304:1: ( '(' )
            // InternalDsl.g:3305:2: '('
            {
             before(grammarAccess.getPrimaryFeatureAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getPrimaryFeatureAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryFeature__Group_1__1"
    // InternalDsl.g:3314:1: rule__PrimaryFeature__Group_1__1 : rule__PrimaryFeature__Group_1__1__Impl rule__PrimaryFeature__Group_1__2 ;
    public final void rule__PrimaryFeature__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3318:1: ( rule__PrimaryFeature__Group_1__1__Impl rule__PrimaryFeature__Group_1__2 )
            // InternalDsl.g:3319:2: rule__PrimaryFeature__Group_1__1__Impl rule__PrimaryFeature__Group_1__2
            {
            pushFollow(FOLLOW_8);
            rule__PrimaryFeature__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryFeature__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Group_1__1"


    // $ANTLR start "rule__PrimaryFeature__Group_1__1__Impl"
    // InternalDsl.g:3326:1: rule__PrimaryFeature__Group_1__1__Impl : ( ruleFeatureExpression ) ;
    public final void rule__PrimaryFeature__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3330:1: ( ( ruleFeatureExpression ) )
            // InternalDsl.g:3331:1: ( ruleFeatureExpression )
            {
            // InternalDsl.g:3331:1: ( ruleFeatureExpression )
            // InternalDsl.g:3332:2: ruleFeatureExpression
            {
             before(grammarAccess.getPrimaryFeatureAccess().getFeatureExpressionParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleFeatureExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryFeatureAccess().getFeatureExpressionParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryFeature__Group_1__2"
    // InternalDsl.g:3341:1: rule__PrimaryFeature__Group_1__2 : rule__PrimaryFeature__Group_1__2__Impl ;
    public final void rule__PrimaryFeature__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3345:1: ( rule__PrimaryFeature__Group_1__2__Impl )
            // InternalDsl.g:3346:2: rule__PrimaryFeature__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryFeature__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Group_1__2"


    // $ANTLR start "rule__PrimaryFeature__Group_1__2__Impl"
    // InternalDsl.g:3352:1: rule__PrimaryFeature__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryFeature__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3356:1: ( ( ')' ) )
            // InternalDsl.g:3357:1: ( ')' )
            {
            // InternalDsl.g:3357:1: ( ')' )
            // InternalDsl.g:3358:2: ')'
            {
             before(grammarAccess.getPrimaryFeatureAccess().getRightParenthesisKeyword_1_2()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPrimaryFeatureAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryFeature__Group_1__2__Impl"


    // $ANTLR start "rule__ImplicationConstraint__Group__0"
    // InternalDsl.g:3368:1: rule__ImplicationConstraint__Group__0 : rule__ImplicationConstraint__Group__0__Impl rule__ImplicationConstraint__Group__1 ;
    public final void rule__ImplicationConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3372:1: ( rule__ImplicationConstraint__Group__0__Impl rule__ImplicationConstraint__Group__1 )
            // InternalDsl.g:3373:2: rule__ImplicationConstraint__Group__0__Impl rule__ImplicationConstraint__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__ImplicationConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group__0"


    // $ANTLR start "rule__ImplicationConstraint__Group__0__Impl"
    // InternalDsl.g:3380:1: rule__ImplicationConstraint__Group__0__Impl : ( ruleOrConstraint ) ;
    public final void rule__ImplicationConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3384:1: ( ( ruleOrConstraint ) )
            // InternalDsl.g:3385:1: ( ruleOrConstraint )
            {
            // InternalDsl.g:3385:1: ( ruleOrConstraint )
            // InternalDsl.g:3386:2: ruleOrConstraint
            {
             before(grammarAccess.getImplicationConstraintAccess().getOrConstraintParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOrConstraint();

            state._fsp--;

             after(grammarAccess.getImplicationConstraintAccess().getOrConstraintParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group__0__Impl"


    // $ANTLR start "rule__ImplicationConstraint__Group__1"
    // InternalDsl.g:3395:1: rule__ImplicationConstraint__Group__1 : rule__ImplicationConstraint__Group__1__Impl ;
    public final void rule__ImplicationConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3399:1: ( rule__ImplicationConstraint__Group__1__Impl )
            // InternalDsl.g:3400:2: rule__ImplicationConstraint__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group__1"


    // $ANTLR start "rule__ImplicationConstraint__Group__1__Impl"
    // InternalDsl.g:3406:1: rule__ImplicationConstraint__Group__1__Impl : ( ( rule__ImplicationConstraint__Group_1__0 )? ) ;
    public final void rule__ImplicationConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3410:1: ( ( ( rule__ImplicationConstraint__Group_1__0 )? ) )
            // InternalDsl.g:3411:1: ( ( rule__ImplicationConstraint__Group_1__0 )? )
            {
            // InternalDsl.g:3411:1: ( ( rule__ImplicationConstraint__Group_1__0 )? )
            // InternalDsl.g:3412:2: ( rule__ImplicationConstraint__Group_1__0 )?
            {
             before(grammarAccess.getImplicationConstraintAccess().getGroup_1()); 
            // InternalDsl.g:3413:2: ( rule__ImplicationConstraint__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==93) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDsl.g:3413:3: rule__ImplicationConstraint__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ImplicationConstraint__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImplicationConstraintAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group__1__Impl"


    // $ANTLR start "rule__ImplicationConstraint__Group_1__0"
    // InternalDsl.g:3422:1: rule__ImplicationConstraint__Group_1__0 : rule__ImplicationConstraint__Group_1__0__Impl rule__ImplicationConstraint__Group_1__1 ;
    public final void rule__ImplicationConstraint__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3426:1: ( rule__ImplicationConstraint__Group_1__0__Impl rule__ImplicationConstraint__Group_1__1 )
            // InternalDsl.g:3427:2: rule__ImplicationConstraint__Group_1__0__Impl rule__ImplicationConstraint__Group_1__1
            {
            pushFollow(FOLLOW_29);
            rule__ImplicationConstraint__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group_1__0"


    // $ANTLR start "rule__ImplicationConstraint__Group_1__0__Impl"
    // InternalDsl.g:3434:1: rule__ImplicationConstraint__Group_1__0__Impl : ( () ) ;
    public final void rule__ImplicationConstraint__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3438:1: ( ( () ) )
            // InternalDsl.g:3439:1: ( () )
            {
            // InternalDsl.g:3439:1: ( () )
            // InternalDsl.g:3440:2: ()
            {
             before(grammarAccess.getImplicationConstraintAccess().getImplicationConstraintRuleLeftRuleAction_1_0()); 
            // InternalDsl.g:3441:2: ()
            // InternalDsl.g:3441:3: 
            {
            }

             after(grammarAccess.getImplicationConstraintAccess().getImplicationConstraintRuleLeftRuleAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group_1__0__Impl"


    // $ANTLR start "rule__ImplicationConstraint__Group_1__1"
    // InternalDsl.g:3449:1: rule__ImplicationConstraint__Group_1__1 : rule__ImplicationConstraint__Group_1__1__Impl rule__ImplicationConstraint__Group_1__2 ;
    public final void rule__ImplicationConstraint__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3453:1: ( rule__ImplicationConstraint__Group_1__1__Impl rule__ImplicationConstraint__Group_1__2 )
            // InternalDsl.g:3454:2: rule__ImplicationConstraint__Group_1__1__Impl rule__ImplicationConstraint__Group_1__2
            {
            pushFollow(FOLLOW_10);
            rule__ImplicationConstraint__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group_1__1"


    // $ANTLR start "rule__ImplicationConstraint__Group_1__1__Impl"
    // InternalDsl.g:3461:1: rule__ImplicationConstraint__Group_1__1__Impl : ( '=>' ) ;
    public final void rule__ImplicationConstraint__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3465:1: ( ( '=>' ) )
            // InternalDsl.g:3466:1: ( '=>' )
            {
            // InternalDsl.g:3466:1: ( '=>' )
            // InternalDsl.g:3467:2: '=>'
            {
             before(grammarAccess.getImplicationConstraintAccess().getEqualsSignGreaterThanSignKeyword_1_1()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getImplicationConstraintAccess().getEqualsSignGreaterThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group_1__1__Impl"


    // $ANTLR start "rule__ImplicationConstraint__Group_1__2"
    // InternalDsl.g:3476:1: rule__ImplicationConstraint__Group_1__2 : rule__ImplicationConstraint__Group_1__2__Impl ;
    public final void rule__ImplicationConstraint__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3480:1: ( rule__ImplicationConstraint__Group_1__2__Impl )
            // InternalDsl.g:3481:2: rule__ImplicationConstraint__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group_1__2"


    // $ANTLR start "rule__ImplicationConstraint__Group_1__2__Impl"
    // InternalDsl.g:3487:1: rule__ImplicationConstraint__Group_1__2__Impl : ( ( rule__ImplicationConstraint__RightRuleAssignment_1_2 ) ) ;
    public final void rule__ImplicationConstraint__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3491:1: ( ( ( rule__ImplicationConstraint__RightRuleAssignment_1_2 ) ) )
            // InternalDsl.g:3492:1: ( ( rule__ImplicationConstraint__RightRuleAssignment_1_2 ) )
            {
            // InternalDsl.g:3492:1: ( ( rule__ImplicationConstraint__RightRuleAssignment_1_2 ) )
            // InternalDsl.g:3493:2: ( rule__ImplicationConstraint__RightRuleAssignment_1_2 )
            {
             before(grammarAccess.getImplicationConstraintAccess().getRightRuleAssignment_1_2()); 
            // InternalDsl.g:3494:2: ( rule__ImplicationConstraint__RightRuleAssignment_1_2 )
            // InternalDsl.g:3494:3: rule__ImplicationConstraint__RightRuleAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ImplicationConstraint__RightRuleAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getImplicationConstraintAccess().getRightRuleAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__Group_1__2__Impl"


    // $ANTLR start "rule__OrConstraint__Group__0"
    // InternalDsl.g:3503:1: rule__OrConstraint__Group__0 : rule__OrConstraint__Group__0__Impl rule__OrConstraint__Group__1 ;
    public final void rule__OrConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3507:1: ( rule__OrConstraint__Group__0__Impl rule__OrConstraint__Group__1 )
            // InternalDsl.g:3508:2: rule__OrConstraint__Group__0__Impl rule__OrConstraint__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__OrConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrConstraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group__0"


    // $ANTLR start "rule__OrConstraint__Group__0__Impl"
    // InternalDsl.g:3515:1: rule__OrConstraint__Group__0__Impl : ( ruleAndConstraint ) ;
    public final void rule__OrConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3519:1: ( ( ruleAndConstraint ) )
            // InternalDsl.g:3520:1: ( ruleAndConstraint )
            {
            // InternalDsl.g:3520:1: ( ruleAndConstraint )
            // InternalDsl.g:3521:2: ruleAndConstraint
            {
             before(grammarAccess.getOrConstraintAccess().getAndConstraintParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndConstraint();

            state._fsp--;

             after(grammarAccess.getOrConstraintAccess().getAndConstraintParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group__0__Impl"


    // $ANTLR start "rule__OrConstraint__Group__1"
    // InternalDsl.g:3530:1: rule__OrConstraint__Group__1 : rule__OrConstraint__Group__1__Impl ;
    public final void rule__OrConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3534:1: ( rule__OrConstraint__Group__1__Impl )
            // InternalDsl.g:3535:2: rule__OrConstraint__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrConstraint__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group__1"


    // $ANTLR start "rule__OrConstraint__Group__1__Impl"
    // InternalDsl.g:3541:1: rule__OrConstraint__Group__1__Impl : ( ( rule__OrConstraint__Group_1__0 )* ) ;
    public final void rule__OrConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3545:1: ( ( ( rule__OrConstraint__Group_1__0 )* ) )
            // InternalDsl.g:3546:1: ( ( rule__OrConstraint__Group_1__0 )* )
            {
            // InternalDsl.g:3546:1: ( ( rule__OrConstraint__Group_1__0 )* )
            // InternalDsl.g:3547:2: ( rule__OrConstraint__Group_1__0 )*
            {
             before(grammarAccess.getOrConstraintAccess().getGroup_1()); 
            // InternalDsl.g:3548:2: ( rule__OrConstraint__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==90) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDsl.g:3548:3: rule__OrConstraint__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__OrConstraint__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getOrConstraintAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group__1__Impl"


    // $ANTLR start "rule__OrConstraint__Group_1__0"
    // InternalDsl.g:3557:1: rule__OrConstraint__Group_1__0 : rule__OrConstraint__Group_1__0__Impl rule__OrConstraint__Group_1__1 ;
    public final void rule__OrConstraint__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3561:1: ( rule__OrConstraint__Group_1__0__Impl rule__OrConstraint__Group_1__1 )
            // InternalDsl.g:3562:2: rule__OrConstraint__Group_1__0__Impl rule__OrConstraint__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__OrConstraint__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrConstraint__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group_1__0"


    // $ANTLR start "rule__OrConstraint__Group_1__0__Impl"
    // InternalDsl.g:3569:1: rule__OrConstraint__Group_1__0__Impl : ( () ) ;
    public final void rule__OrConstraint__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3573:1: ( ( () ) )
            // InternalDsl.g:3574:1: ( () )
            {
            // InternalDsl.g:3574:1: ( () )
            // InternalDsl.g:3575:2: ()
            {
             before(grammarAccess.getOrConstraintAccess().getOrConstraintRuleRulesAction_1_0()); 
            // InternalDsl.g:3576:2: ()
            // InternalDsl.g:3576:3: 
            {
            }

             after(grammarAccess.getOrConstraintAccess().getOrConstraintRuleRulesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group_1__0__Impl"


    // $ANTLR start "rule__OrConstraint__Group_1__1"
    // InternalDsl.g:3584:1: rule__OrConstraint__Group_1__1 : rule__OrConstraint__Group_1__1__Impl rule__OrConstraint__Group_1__2 ;
    public final void rule__OrConstraint__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3588:1: ( rule__OrConstraint__Group_1__1__Impl rule__OrConstraint__Group_1__2 )
            // InternalDsl.g:3589:2: rule__OrConstraint__Group_1__1__Impl rule__OrConstraint__Group_1__2
            {
            pushFollow(FOLLOW_10);
            rule__OrConstraint__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrConstraint__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group_1__1"


    // $ANTLR start "rule__OrConstraint__Group_1__1__Impl"
    // InternalDsl.g:3596:1: rule__OrConstraint__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__OrConstraint__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3600:1: ( ( 'or' ) )
            // InternalDsl.g:3601:1: ( 'or' )
            {
            // InternalDsl.g:3601:1: ( 'or' )
            // InternalDsl.g:3602:2: 'or'
            {
             before(grammarAccess.getOrConstraintAccess().getOrKeyword_1_1()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getOrConstraintAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group_1__1__Impl"


    // $ANTLR start "rule__OrConstraint__Group_1__2"
    // InternalDsl.g:3611:1: rule__OrConstraint__Group_1__2 : rule__OrConstraint__Group_1__2__Impl ;
    public final void rule__OrConstraint__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3615:1: ( rule__OrConstraint__Group_1__2__Impl )
            // InternalDsl.g:3616:2: rule__OrConstraint__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrConstraint__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group_1__2"


    // $ANTLR start "rule__OrConstraint__Group_1__2__Impl"
    // InternalDsl.g:3622:1: rule__OrConstraint__Group_1__2__Impl : ( ( rule__OrConstraint__RulesAssignment_1_2 ) ) ;
    public final void rule__OrConstraint__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3626:1: ( ( ( rule__OrConstraint__RulesAssignment_1_2 ) ) )
            // InternalDsl.g:3627:1: ( ( rule__OrConstraint__RulesAssignment_1_2 ) )
            {
            // InternalDsl.g:3627:1: ( ( rule__OrConstraint__RulesAssignment_1_2 ) )
            // InternalDsl.g:3628:2: ( rule__OrConstraint__RulesAssignment_1_2 )
            {
             before(grammarAccess.getOrConstraintAccess().getRulesAssignment_1_2()); 
            // InternalDsl.g:3629:2: ( rule__OrConstraint__RulesAssignment_1_2 )
            // InternalDsl.g:3629:3: rule__OrConstraint__RulesAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrConstraint__RulesAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrConstraintAccess().getRulesAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__Group_1__2__Impl"


    // $ANTLR start "rule__AndConstraint__Group__0"
    // InternalDsl.g:3638:1: rule__AndConstraint__Group__0 : rule__AndConstraint__Group__0__Impl rule__AndConstraint__Group__1 ;
    public final void rule__AndConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3642:1: ( rule__AndConstraint__Group__0__Impl rule__AndConstraint__Group__1 )
            // InternalDsl.g:3643:2: rule__AndConstraint__Group__0__Impl rule__AndConstraint__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__AndConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndConstraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group__0"


    // $ANTLR start "rule__AndConstraint__Group__0__Impl"
    // InternalDsl.g:3650:1: rule__AndConstraint__Group__0__Impl : ( ruleNotConstraintExpression ) ;
    public final void rule__AndConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3654:1: ( ( ruleNotConstraintExpression ) )
            // InternalDsl.g:3655:1: ( ruleNotConstraintExpression )
            {
            // InternalDsl.g:3655:1: ( ruleNotConstraintExpression )
            // InternalDsl.g:3656:2: ruleNotConstraintExpression
            {
             before(grammarAccess.getAndConstraintAccess().getNotConstraintExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleNotConstraintExpression();

            state._fsp--;

             after(grammarAccess.getAndConstraintAccess().getNotConstraintExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group__0__Impl"


    // $ANTLR start "rule__AndConstraint__Group__1"
    // InternalDsl.g:3665:1: rule__AndConstraint__Group__1 : rule__AndConstraint__Group__1__Impl ;
    public final void rule__AndConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3669:1: ( rule__AndConstraint__Group__1__Impl )
            // InternalDsl.g:3670:2: rule__AndConstraint__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndConstraint__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group__1"


    // $ANTLR start "rule__AndConstraint__Group__1__Impl"
    // InternalDsl.g:3676:1: rule__AndConstraint__Group__1__Impl : ( ( rule__AndConstraint__Group_1__0 )* ) ;
    public final void rule__AndConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3680:1: ( ( ( rule__AndConstraint__Group_1__0 )* ) )
            // InternalDsl.g:3681:1: ( ( rule__AndConstraint__Group_1__0 )* )
            {
            // InternalDsl.g:3681:1: ( ( rule__AndConstraint__Group_1__0 )* )
            // InternalDsl.g:3682:2: ( rule__AndConstraint__Group_1__0 )*
            {
             before(grammarAccess.getAndConstraintAccess().getGroup_1()); 
            // InternalDsl.g:3683:2: ( rule__AndConstraint__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==91) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDsl.g:3683:3: rule__AndConstraint__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__AndConstraint__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getAndConstraintAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group__1__Impl"


    // $ANTLR start "rule__AndConstraint__Group_1__0"
    // InternalDsl.g:3692:1: rule__AndConstraint__Group_1__0 : rule__AndConstraint__Group_1__0__Impl rule__AndConstraint__Group_1__1 ;
    public final void rule__AndConstraint__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3696:1: ( rule__AndConstraint__Group_1__0__Impl rule__AndConstraint__Group_1__1 )
            // InternalDsl.g:3697:2: rule__AndConstraint__Group_1__0__Impl rule__AndConstraint__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__AndConstraint__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndConstraint__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group_1__0"


    // $ANTLR start "rule__AndConstraint__Group_1__0__Impl"
    // InternalDsl.g:3704:1: rule__AndConstraint__Group_1__0__Impl : ( () ) ;
    public final void rule__AndConstraint__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3708:1: ( ( () ) )
            // InternalDsl.g:3709:1: ( () )
            {
            // InternalDsl.g:3709:1: ( () )
            // InternalDsl.g:3710:2: ()
            {
             before(grammarAccess.getAndConstraintAccess().getAndConstraintRuleRulesAction_1_0()); 
            // InternalDsl.g:3711:2: ()
            // InternalDsl.g:3711:3: 
            {
            }

             after(grammarAccess.getAndConstraintAccess().getAndConstraintRuleRulesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group_1__0__Impl"


    // $ANTLR start "rule__AndConstraint__Group_1__1"
    // InternalDsl.g:3719:1: rule__AndConstraint__Group_1__1 : rule__AndConstraint__Group_1__1__Impl rule__AndConstraint__Group_1__2 ;
    public final void rule__AndConstraint__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3723:1: ( rule__AndConstraint__Group_1__1__Impl rule__AndConstraint__Group_1__2 )
            // InternalDsl.g:3724:2: rule__AndConstraint__Group_1__1__Impl rule__AndConstraint__Group_1__2
            {
            pushFollow(FOLLOW_10);
            rule__AndConstraint__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndConstraint__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group_1__1"


    // $ANTLR start "rule__AndConstraint__Group_1__1__Impl"
    // InternalDsl.g:3731:1: rule__AndConstraint__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__AndConstraint__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3735:1: ( ( 'and' ) )
            // InternalDsl.g:3736:1: ( 'and' )
            {
            // InternalDsl.g:3736:1: ( 'and' )
            // InternalDsl.g:3737:2: 'and'
            {
             before(grammarAccess.getAndConstraintAccess().getAndKeyword_1_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getAndConstraintAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group_1__1__Impl"


    // $ANTLR start "rule__AndConstraint__Group_1__2"
    // InternalDsl.g:3746:1: rule__AndConstraint__Group_1__2 : rule__AndConstraint__Group_1__2__Impl ;
    public final void rule__AndConstraint__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3750:1: ( rule__AndConstraint__Group_1__2__Impl )
            // InternalDsl.g:3751:2: rule__AndConstraint__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndConstraint__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group_1__2"


    // $ANTLR start "rule__AndConstraint__Group_1__2__Impl"
    // InternalDsl.g:3757:1: rule__AndConstraint__Group_1__2__Impl : ( ( rule__AndConstraint__RulesAssignment_1_2 ) ) ;
    public final void rule__AndConstraint__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3761:1: ( ( ( rule__AndConstraint__RulesAssignment_1_2 ) ) )
            // InternalDsl.g:3762:1: ( ( rule__AndConstraint__RulesAssignment_1_2 ) )
            {
            // InternalDsl.g:3762:1: ( ( rule__AndConstraint__RulesAssignment_1_2 ) )
            // InternalDsl.g:3763:2: ( rule__AndConstraint__RulesAssignment_1_2 )
            {
             before(grammarAccess.getAndConstraintAccess().getRulesAssignment_1_2()); 
            // InternalDsl.g:3764:2: ( rule__AndConstraint__RulesAssignment_1_2 )
            // InternalDsl.g:3764:3: rule__AndConstraint__RulesAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndConstraint__RulesAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndConstraintAccess().getRulesAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__Group_1__2__Impl"


    // $ANTLR start "rule__NotConstraintExpression__Group_1__0"
    // InternalDsl.g:3773:1: rule__NotConstraintExpression__Group_1__0 : rule__NotConstraintExpression__Group_1__0__Impl rule__NotConstraintExpression__Group_1__1 ;
    public final void rule__NotConstraintExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3777:1: ( rule__NotConstraintExpression__Group_1__0__Impl rule__NotConstraintExpression__Group_1__1 )
            // InternalDsl.g:3778:2: rule__NotConstraintExpression__Group_1__0__Impl rule__NotConstraintExpression__Group_1__1
            {
            pushFollow(FOLLOW_30);
            rule__NotConstraintExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotConstraintExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Group_1__0"


    // $ANTLR start "rule__NotConstraintExpression__Group_1__0__Impl"
    // InternalDsl.g:3785:1: rule__NotConstraintExpression__Group_1__0__Impl : ( '!' ) ;
    public final void rule__NotConstraintExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3789:1: ( ( '!' ) )
            // InternalDsl.g:3790:1: ( '!' )
            {
            // InternalDsl.g:3790:1: ( '!' )
            // InternalDsl.g:3791:2: '!'
            {
             before(grammarAccess.getNotConstraintExpressionAccess().getExclamationMarkKeyword_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getNotConstraintExpressionAccess().getExclamationMarkKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NotConstraintExpression__Group_1__1"
    // InternalDsl.g:3800:1: rule__NotConstraintExpression__Group_1__1 : rule__NotConstraintExpression__Group_1__1__Impl rule__NotConstraintExpression__Group_1__2 ;
    public final void rule__NotConstraintExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3804:1: ( rule__NotConstraintExpression__Group_1__1__Impl rule__NotConstraintExpression__Group_1__2 )
            // InternalDsl.g:3805:2: rule__NotConstraintExpression__Group_1__1__Impl rule__NotConstraintExpression__Group_1__2
            {
            pushFollow(FOLLOW_30);
            rule__NotConstraintExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotConstraintExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Group_1__1"


    // $ANTLR start "rule__NotConstraintExpression__Group_1__1__Impl"
    // InternalDsl.g:3812:1: rule__NotConstraintExpression__Group_1__1__Impl : ( () ) ;
    public final void rule__NotConstraintExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3816:1: ( ( () ) )
            // InternalDsl.g:3817:1: ( () )
            {
            // InternalDsl.g:3817:1: ( () )
            // InternalDsl.g:3818:2: ()
            {
             before(grammarAccess.getNotConstraintExpressionAccess().getNotConstraintRuleAction_1_1()); 
            // InternalDsl.g:3819:2: ()
            // InternalDsl.g:3819:3: 
            {
            }

             after(grammarAccess.getNotConstraintExpressionAccess().getNotConstraintRuleAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Group_1__1__Impl"


    // $ANTLR start "rule__NotConstraintExpression__Group_1__2"
    // InternalDsl.g:3827:1: rule__NotConstraintExpression__Group_1__2 : rule__NotConstraintExpression__Group_1__2__Impl ;
    public final void rule__NotConstraintExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3831:1: ( rule__NotConstraintExpression__Group_1__2__Impl )
            // InternalDsl.g:3832:2: rule__NotConstraintExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NotConstraintExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Group_1__2"


    // $ANTLR start "rule__NotConstraintExpression__Group_1__2__Impl"
    // InternalDsl.g:3838:1: rule__NotConstraintExpression__Group_1__2__Impl : ( ( rule__NotConstraintExpression__RuleAssignment_1_2 ) ) ;
    public final void rule__NotConstraintExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3842:1: ( ( ( rule__NotConstraintExpression__RuleAssignment_1_2 ) ) )
            // InternalDsl.g:3843:1: ( ( rule__NotConstraintExpression__RuleAssignment_1_2 ) )
            {
            // InternalDsl.g:3843:1: ( ( rule__NotConstraintExpression__RuleAssignment_1_2 ) )
            // InternalDsl.g:3844:2: ( rule__NotConstraintExpression__RuleAssignment_1_2 )
            {
             before(grammarAccess.getNotConstraintExpressionAccess().getRuleAssignment_1_2()); 
            // InternalDsl.g:3845:2: ( rule__NotConstraintExpression__RuleAssignment_1_2 )
            // InternalDsl.g:3845:3: rule__NotConstraintExpression__RuleAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__NotConstraintExpression__RuleAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNotConstraintExpressionAccess().getRuleAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__Group_1__2__Impl"


    // $ANTLR start "rule__PrimaryConstraint__Group_1__0"
    // InternalDsl.g:3854:1: rule__PrimaryConstraint__Group_1__0 : rule__PrimaryConstraint__Group_1__0__Impl rule__PrimaryConstraint__Group_1__1 ;
    public final void rule__PrimaryConstraint__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3858:1: ( rule__PrimaryConstraint__Group_1__0__Impl rule__PrimaryConstraint__Group_1__1 )
            // InternalDsl.g:3859:2: rule__PrimaryConstraint__Group_1__0__Impl rule__PrimaryConstraint__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__PrimaryConstraint__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryConstraint__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Group_1__0"


    // $ANTLR start "rule__PrimaryConstraint__Group_1__0__Impl"
    // InternalDsl.g:3866:1: rule__PrimaryConstraint__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryConstraint__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3870:1: ( ( '(' ) )
            // InternalDsl.g:3871:1: ( '(' )
            {
            // InternalDsl.g:3871:1: ( '(' )
            // InternalDsl.g:3872:2: '('
            {
             before(grammarAccess.getPrimaryConstraintAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getPrimaryConstraintAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryConstraint__Group_1__1"
    // InternalDsl.g:3881:1: rule__PrimaryConstraint__Group_1__1 : rule__PrimaryConstraint__Group_1__1__Impl rule__PrimaryConstraint__Group_1__2 ;
    public final void rule__PrimaryConstraint__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3885:1: ( rule__PrimaryConstraint__Group_1__1__Impl rule__PrimaryConstraint__Group_1__2 )
            // InternalDsl.g:3886:2: rule__PrimaryConstraint__Group_1__1__Impl rule__PrimaryConstraint__Group_1__2
            {
            pushFollow(FOLLOW_8);
            rule__PrimaryConstraint__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryConstraint__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Group_1__1"


    // $ANTLR start "rule__PrimaryConstraint__Group_1__1__Impl"
    // InternalDsl.g:3893:1: rule__PrimaryConstraint__Group_1__1__Impl : ( ruleConstraintExpression ) ;
    public final void rule__PrimaryConstraint__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3897:1: ( ( ruleConstraintExpression ) )
            // InternalDsl.g:3898:1: ( ruleConstraintExpression )
            {
            // InternalDsl.g:3898:1: ( ruleConstraintExpression )
            // InternalDsl.g:3899:2: ruleConstraintExpression
            {
             before(grammarAccess.getPrimaryConstraintAccess().getConstraintExpressionParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleConstraintExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryConstraintAccess().getConstraintExpressionParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryConstraint__Group_1__2"
    // InternalDsl.g:3908:1: rule__PrimaryConstraint__Group_1__2 : rule__PrimaryConstraint__Group_1__2__Impl ;
    public final void rule__PrimaryConstraint__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3912:1: ( rule__PrimaryConstraint__Group_1__2__Impl )
            // InternalDsl.g:3913:2: rule__PrimaryConstraint__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryConstraint__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Group_1__2"


    // $ANTLR start "rule__PrimaryConstraint__Group_1__2__Impl"
    // InternalDsl.g:3919:1: rule__PrimaryConstraint__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryConstraint__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3923:1: ( ( ')' ) )
            // InternalDsl.g:3924:1: ( ')' )
            {
            // InternalDsl.g:3924:1: ( ')' )
            // InternalDsl.g:3925:2: ')'
            {
             before(grammarAccess.getPrimaryConstraintAccess().getRightParenthesisKeyword_1_2()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPrimaryConstraintAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryConstraint__Group_1__2__Impl"


    // $ANTLR start "rule__Model__PoliciesAssignment_0"
    // InternalDsl.g:3935:1: rule__Model__PoliciesAssignment_0 : ( rulePolicy ) ;
    public final void rule__Model__PoliciesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3939:1: ( ( rulePolicy ) )
            // InternalDsl.g:3940:2: ( rulePolicy )
            {
            // InternalDsl.g:3940:2: ( rulePolicy )
            // InternalDsl.g:3941:3: rulePolicy
            {
             before(grammarAccess.getModelAccess().getPoliciesPolicyParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePolicy();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPoliciesPolicyParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PoliciesAssignment_0"


    // $ANTLR start "rule__Model__PoliciesAssignment_1"
    // InternalDsl.g:3950:1: rule__Model__PoliciesAssignment_1 : ( rulePolicy ) ;
    public final void rule__Model__PoliciesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3954:1: ( ( rulePolicy ) )
            // InternalDsl.g:3955:2: ( rulePolicy )
            {
            // InternalDsl.g:3955:2: ( rulePolicy )
            // InternalDsl.g:3956:3: rulePolicy
            {
             before(grammarAccess.getModelAccess().getPoliciesPolicyParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePolicy();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPoliciesPolicyParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PoliciesAssignment_1"


    // $ANTLR start "rule__Policy__OverrideAssignment_0"
    // InternalDsl.g:3965:1: rule__Policy__OverrideAssignment_0 : ( ( 'override' ) ) ;
    public final void rule__Policy__OverrideAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3969:1: ( ( ( 'override' ) ) )
            // InternalDsl.g:3970:2: ( ( 'override' ) )
            {
            // InternalDsl.g:3970:2: ( ( 'override' ) )
            // InternalDsl.g:3971:3: ( 'override' )
            {
             before(grammarAccess.getPolicyAccess().getOverrideOverrideKeyword_0_0()); 
            // InternalDsl.g:3972:3: ( 'override' )
            // InternalDsl.g:3973:4: 'override'
            {
             before(grammarAccess.getPolicyAccess().getOverrideOverrideKeyword_0_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getPolicyAccess().getOverrideOverrideKeyword_0_0()); 

            }

             after(grammarAccess.getPolicyAccess().getOverrideOverrideKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__OverrideAssignment_0"


    // $ANTLR start "rule__Policy__ActionAssignment_1"
    // InternalDsl.g:3984:1: rule__Policy__ActionAssignment_1 : ( ruleActionEnum ) ;
    public final void rule__Policy__ActionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:3988:1: ( ( ruleActionEnum ) )
            // InternalDsl.g:3989:2: ( ruleActionEnum )
            {
            // InternalDsl.g:3989:2: ( ruleActionEnum )
            // InternalDsl.g:3990:3: ruleActionEnum
            {
             before(grammarAccess.getPolicyAccess().getActionActionEnumEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleActionEnum();

            state._fsp--;

             after(grammarAccess.getPolicyAccess().getActionActionEnumEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__ActionAssignment_1"


    // $ANTLR start "rule__Policy__ActionTypeAssignment_2"
    // InternalDsl.g:3999:1: rule__Policy__ActionTypeAssignment_2 : ( ruleFeatureTypeEnum ) ;
    public final void rule__Policy__ActionTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4003:1: ( ( ruleFeatureTypeEnum ) )
            // InternalDsl.g:4004:2: ( ruleFeatureTypeEnum )
            {
            // InternalDsl.g:4004:2: ( ruleFeatureTypeEnum )
            // InternalDsl.g:4005:3: ruleFeatureTypeEnum
            {
             before(grammarAccess.getPolicyAccess().getActionTypeFeatureTypeEnumEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureTypeEnum();

            state._fsp--;

             after(grammarAccess.getPolicyAccess().getActionTypeFeatureTypeEnumEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__ActionTypeAssignment_2"


    // $ANTLR start "rule__Policy__FeatureRuleAssignment_4"
    // InternalDsl.g:4014:1: rule__Policy__FeatureRuleAssignment_4 : ( ruleFeatureExpression ) ;
    public final void rule__Policy__FeatureRuleAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4018:1: ( ( ruleFeatureExpression ) )
            // InternalDsl.g:4019:2: ( ruleFeatureExpression )
            {
            // InternalDsl.g:4019:2: ( ruleFeatureExpression )
            // InternalDsl.g:4020:3: ruleFeatureExpression
            {
             before(grammarAccess.getPolicyAccess().getFeatureRuleFeatureExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureExpression();

            state._fsp--;

             after(grammarAccess.getPolicyAccess().getFeatureRuleFeatureExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__FeatureRuleAssignment_4"


    // $ANTLR start "rule__Policy__ConstraintRuleAssignment_7"
    // InternalDsl.g:4029:1: rule__Policy__ConstraintRuleAssignment_7 : ( ruleConstraintExpression ) ;
    public final void rule__Policy__ConstraintRuleAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4033:1: ( ( ruleConstraintExpression ) )
            // InternalDsl.g:4034:2: ( ruleConstraintExpression )
            {
            // InternalDsl.g:4034:2: ( ruleConstraintExpression )
            // InternalDsl.g:4035:3: ruleConstraintExpression
            {
             before(grammarAccess.getPolicyAccess().getConstraintRuleConstraintExpressionParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraintExpression();

            state._fsp--;

             after(grammarAccess.getPolicyAccess().getConstraintRuleConstraintExpressionParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Policy__ConstraintRuleAssignment_7"


    // $ANTLR start "rule__IsTargetTypeConstraintRule__TypeAssignment_3"
    // InternalDsl.g:4044:1: rule__IsTargetTypeConstraintRule__TypeAssignment_3 : ( ruleFeatureTypeEnum ) ;
    public final void rule__IsTargetTypeConstraintRule__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4048:1: ( ( ruleFeatureTypeEnum ) )
            // InternalDsl.g:4049:2: ( ruleFeatureTypeEnum )
            {
            // InternalDsl.g:4049:2: ( ruleFeatureTypeEnum )
            // InternalDsl.g:4050:3: ruleFeatureTypeEnum
            {
             before(grammarAccess.getIsTargetTypeConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureTypeEnum();

            state._fsp--;

             after(grammarAccess.getIsTargetTypeConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetTypeConstraintRule__TypeAssignment_3"


    // $ANTLR start "rule__IsParentConstraintRule__TypeAssignment_3"
    // InternalDsl.g:4059:1: rule__IsParentConstraintRule__TypeAssignment_3 : ( ruleFeatureTypeEnum ) ;
    public final void rule__IsParentConstraintRule__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4063:1: ( ( ruleFeatureTypeEnum ) )
            // InternalDsl.g:4064:2: ( ruleFeatureTypeEnum )
            {
            // InternalDsl.g:4064:2: ( ruleFeatureTypeEnum )
            // InternalDsl.g:4065:3: ruleFeatureTypeEnum
            {
             before(grammarAccess.getIsParentConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureTypeEnum();

            state._fsp--;

             after(grammarAccess.getIsParentConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsParentConstraintRule__TypeAssignment_3"


    // $ANTLR start "rule__IsSourceTypeConstraintRule__TypeAssignment_3"
    // InternalDsl.g:4074:1: rule__IsSourceTypeConstraintRule__TypeAssignment_3 : ( ruleFeatureTypeEnum ) ;
    public final void rule__IsSourceTypeConstraintRule__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4078:1: ( ( ruleFeatureTypeEnum ) )
            // InternalDsl.g:4079:2: ( ruleFeatureTypeEnum )
            {
            // InternalDsl.g:4079:2: ( ruleFeatureTypeEnum )
            // InternalDsl.g:4080:3: ruleFeatureTypeEnum
            {
             before(grammarAccess.getIsSourceTypeConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureTypeEnum();

            state._fsp--;

             after(grammarAccess.getIsSourceTypeConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsSourceTypeConstraintRule__TypeAssignment_3"


    // $ANTLR start "rule__IsTargetConstraintRule__TypeAssignment_3"
    // InternalDsl.g:4089:1: rule__IsTargetConstraintRule__TypeAssignment_3 : ( ruleFeatureTypeEnum ) ;
    public final void rule__IsTargetConstraintRule__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4093:1: ( ( ruleFeatureTypeEnum ) )
            // InternalDsl.g:4094:2: ( ruleFeatureTypeEnum )
            {
            // InternalDsl.g:4094:2: ( ruleFeatureTypeEnum )
            // InternalDsl.g:4095:3: ruleFeatureTypeEnum
            {
             before(grammarAccess.getIsTargetConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureTypeEnum();

            state._fsp--;

             after(grammarAccess.getIsTargetConstraintRuleAccess().getTypeFeatureTypeEnumEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsTargetConstraintRule__TypeAssignment_3"


    // $ANTLR start "rule__IsFeature__FeatureNameAssignment_1"
    // InternalDsl.g:4104:1: rule__IsFeature__FeatureNameAssignment_1 : ( ruleFeatureNameEnum ) ;
    public final void rule__IsFeature__FeatureNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4108:1: ( ( ruleFeatureNameEnum ) )
            // InternalDsl.g:4109:2: ( ruleFeatureNameEnum )
            {
            // InternalDsl.g:4109:2: ( ruleFeatureNameEnum )
            // InternalDsl.g:4110:3: ruleFeatureNameEnum
            {
             before(grammarAccess.getIsFeatureAccess().getFeatureNameFeatureNameEnumEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureNameEnum();

            state._fsp--;

             after(grammarAccess.getIsFeatureAccess().getFeatureNameFeatureNameEnumEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsFeature__FeatureNameAssignment_1"


    // $ANTLR start "rule__OrFeature__RulesAssignment_1_2"
    // InternalDsl.g:4119:1: rule__OrFeature__RulesAssignment_1_2 : ( ruleAndFeature ) ;
    public final void rule__OrFeature__RulesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4123:1: ( ( ruleAndFeature ) )
            // InternalDsl.g:4124:2: ( ruleAndFeature )
            {
            // InternalDsl.g:4124:2: ( ruleAndFeature )
            // InternalDsl.g:4125:3: ruleAndFeature
            {
             before(grammarAccess.getOrFeatureAccess().getRulesAndFeatureParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndFeature();

            state._fsp--;

             after(grammarAccess.getOrFeatureAccess().getRulesAndFeatureParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrFeature__RulesAssignment_1_2"


    // $ANTLR start "rule__AndFeature__RulesAssignment_1_2"
    // InternalDsl.g:4134:1: rule__AndFeature__RulesAssignment_1_2 : ( ruleNotFeatureExpression ) ;
    public final void rule__AndFeature__RulesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4138:1: ( ( ruleNotFeatureExpression ) )
            // InternalDsl.g:4139:2: ( ruleNotFeatureExpression )
            {
            // InternalDsl.g:4139:2: ( ruleNotFeatureExpression )
            // InternalDsl.g:4140:3: ruleNotFeatureExpression
            {
             before(grammarAccess.getAndFeatureAccess().getRulesNotFeatureExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNotFeatureExpression();

            state._fsp--;

             after(grammarAccess.getAndFeatureAccess().getRulesNotFeatureExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndFeature__RulesAssignment_1_2"


    // $ANTLR start "rule__NotFeatureExpression__RuleAssignment_1_2"
    // InternalDsl.g:4149:1: rule__NotFeatureExpression__RuleAssignment_1_2 : ( rulePrimaryFeature ) ;
    public final void rule__NotFeatureExpression__RuleAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4153:1: ( ( rulePrimaryFeature ) )
            // InternalDsl.g:4154:2: ( rulePrimaryFeature )
            {
            // InternalDsl.g:4154:2: ( rulePrimaryFeature )
            // InternalDsl.g:4155:3: rulePrimaryFeature
            {
             before(grammarAccess.getNotFeatureExpressionAccess().getRulePrimaryFeatureParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryFeature();

            state._fsp--;

             after(grammarAccess.getNotFeatureExpressionAccess().getRulePrimaryFeatureParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotFeatureExpression__RuleAssignment_1_2"


    // $ANTLR start "rule__ImplicationConstraint__RightRuleAssignment_1_2"
    // InternalDsl.g:4164:1: rule__ImplicationConstraint__RightRuleAssignment_1_2 : ( ruleOrConstraint ) ;
    public final void rule__ImplicationConstraint__RightRuleAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4168:1: ( ( ruleOrConstraint ) )
            // InternalDsl.g:4169:2: ( ruleOrConstraint )
            {
            // InternalDsl.g:4169:2: ( ruleOrConstraint )
            // InternalDsl.g:4170:3: ruleOrConstraint
            {
             before(grammarAccess.getImplicationConstraintAccess().getRightRuleOrConstraintParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOrConstraint();

            state._fsp--;

             after(grammarAccess.getImplicationConstraintAccess().getRightRuleOrConstraintParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImplicationConstraint__RightRuleAssignment_1_2"


    // $ANTLR start "rule__OrConstraint__RulesAssignment_1_2"
    // InternalDsl.g:4179:1: rule__OrConstraint__RulesAssignment_1_2 : ( ruleAndConstraint ) ;
    public final void rule__OrConstraint__RulesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4183:1: ( ( ruleAndConstraint ) )
            // InternalDsl.g:4184:2: ( ruleAndConstraint )
            {
            // InternalDsl.g:4184:2: ( ruleAndConstraint )
            // InternalDsl.g:4185:3: ruleAndConstraint
            {
             before(grammarAccess.getOrConstraintAccess().getRulesAndConstraintParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndConstraint();

            state._fsp--;

             after(grammarAccess.getOrConstraintAccess().getRulesAndConstraintParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrConstraint__RulesAssignment_1_2"


    // $ANTLR start "rule__AndConstraint__RulesAssignment_1_2"
    // InternalDsl.g:4194:1: rule__AndConstraint__RulesAssignment_1_2 : ( ruleNotConstraintExpression ) ;
    public final void rule__AndConstraint__RulesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4198:1: ( ( ruleNotConstraintExpression ) )
            // InternalDsl.g:4199:2: ( ruleNotConstraintExpression )
            {
            // InternalDsl.g:4199:2: ( ruleNotConstraintExpression )
            // InternalDsl.g:4200:3: ruleNotConstraintExpression
            {
             before(grammarAccess.getAndConstraintAccess().getRulesNotConstraintExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNotConstraintExpression();

            state._fsp--;

             after(grammarAccess.getAndConstraintAccess().getRulesNotConstraintExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndConstraint__RulesAssignment_1_2"


    // $ANTLR start "rule__NotConstraintExpression__RuleAssignment_1_2"
    // InternalDsl.g:4209:1: rule__NotConstraintExpression__RuleAssignment_1_2 : ( rulePrimaryConstraint ) ;
    public final void rule__NotConstraintExpression__RuleAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDsl.g:4213:1: ( ( rulePrimaryConstraint ) )
            // InternalDsl.g:4214:2: ( rulePrimaryConstraint )
            {
            // InternalDsl.g:4214:2: ( rulePrimaryConstraint )
            // InternalDsl.g:4215:3: rulePrimaryConstraint
            {
             before(grammarAccess.getNotConstraintExpressionAccess().getRulePrimaryConstraintParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryConstraint();

            state._fsp--;

             after(grammarAccess.getNotConstraintExpressionAccess().getRulePrimaryConstraintParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotConstraintExpression__RuleAssignment_1_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000001FF800L,0x0000000040000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000001FF802L,0x0000000040000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000007FFFE00000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xFFFFFF8000000000L,0x0000000013001FFFL});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000013FF1000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000003FF0000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFF8000000000L,0x0000000000000FFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFFFFFF8000000000L,0x0000000003000FFFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xFFFFFF8000000000L,0x0000000003001FFFL});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000003FF1000L});

}