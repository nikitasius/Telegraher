/**
 * Copyright 2022  Nikita S. <nikita@saraeff.net>
 * <p>
 * This file is part of Telegraher.
 * <p>
 * Telegraher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Telegraher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Telegraher.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.evildayz.code.telegraher;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.evildayz.code.telegraher.devicespoofing.DSMainActivity;
//import com.evildayz.code.telegraher.ui.UIFontActivity;

import com.evildayz.code.telegraher.session.THDeviceSpoofingEditActivity;
import com.evildayz.code.telegraher.session.ThSessionManagerActivity;
import org.telegram.messenger.*;
import org.telegram.ui.ActionBar.*;
import org.telegram.ui.Cells.HeaderCell;
import org.telegram.ui.Cells.NotificationsCheckCell;
import org.telegram.ui.Cells.ShadowSectionCell;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Cells.TextDetailCell;
import org.telegram.ui.Cells.TextDetailSettingsCell;
import org.telegram.ui.Cells.TextInfoPrivacyCell;
import org.telegram.ui.Cells.TextSettingsCell;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;
import org.telegram.ui.Components.SlideChooseView;
import org.telegram.ui.QrActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class TelegraherSettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private RecyclerListView listView;

    private TelegraherSettingsActivity.ListAdapter adapter;
    @SuppressWarnings("FieldCanBeLocal")
    private LinearLayoutManager layoutManager;

    private int showLabelTelegraherMenuRow;
    private int showTelegraherMenuRow;

    private int voiceLabelRow;
    private int voiceHDRow;
    private int voiceBadmanRow;

    private int voipLabelRow;
    private int voipHDRow;
    private int voipDisableStartBeep;
    private int voipDisableEndBeep;

    private int uiLabelRow;
    private int uiAppNotificationIconRow;
    private int uiAppNotificationIconSelectorRow;
    private int uiStickerSizeLabelRow;
    private int uiStickerSizeRow;
    private int uiAppHidePhoneNumberOnLeftPanelRow;
    private int uiSystemFontRegularRow;
    private int uiSystemFontBoldRow;
    private int uiSystemFontItalicRow;
    private int uiSystemFontBoldItalicRow;
    private int uiSystemFontMonoRow;

    private int hardwareLabelRow;
    private int hardwareProximitySensorModeLabelRow;
    private int hardwareProximitySensorModeRow;
    private int hardwareDisableVibroRow;

    private int privacyLabelRow;
    private int privacyDontCallAppleRow;

    private int profileLabelRow;
    private int profileUIDRow;
    private int profileDCIDRow;
    private int profileSBRow;

    private int chatLabelRow;
    private int chatDeleteMarkRow;
    private int chatEnableMessageHistoryRow;
    private int chatSBFullRow;
    private int chatSBManagerRow;
    private int chatSwapToNextChannelRow;
    private int chatBottomOverlayNativeBehaviorRow;
    private int chatTabsOnForwardRow;
    private int chatDisableSpoilersRow;
    private int chatHideAllInSpoilersRow;
    private int chatRealForwardedMessageTimeRow;
    private int chatHideStickersRow;
    private int chatHideAnimatedStickersRow;
    private int chatHideVideoStickersRow;

    private int videoLabelRoundBitrateRow;
    private int videoRoundBitrateMultRow;
    private int videoLabelRoundSizeRow;
    private int videoRoundSizeMultRow;
    private int videoRoundUseMainCameraRow;
    private int photoSizeMaxLabelRow;
    private int photoSizeMaxRow;

    private int videoLabelMaxResolutionRow;
    private int videoMaxResolutionRow;

    private int gifLabelHDRow;
    private int gifHDRow;

    private int accountLabelRow;
    private int accountSessionManagerRow;
    private int accountExtendVanillaRow;

    private int graheriumLabelRow;
    private int graheriumSpeedUpUpload;
    private int graheriumSpeedUpDownload;
    private int graheriumAnimateEveryAvatar;
    private int graheriumVanillaStickerFlow;
    private int graheriumAnimatedStickerOverlays;
    private int graheriumStarrLabelRow;
    private int graheriumStarrMark;
    private int graheriumOverrideConnectionSpeedLabelRow;
    private int graheriumOverrideConnectionSpeed;
    private int graheriumDisableEmojiStatus;
    private int graheriumDisablePremiumEmojis;

    private int deviceSpoofingLabelRow;
    private int deviceSpoofingBrand;
    private int deviceSpoofingModel;
    private int deviceSpoofingSDK;
    private int deviceSpoofingResetDefaultLabelRow;

    private int killMeLabelRow;

    private int rowCount = 0;

    @Override
    public boolean onFragmentCreate() {
        showLabelTelegraherMenuRow = rowCount++;
        showTelegraherMenuRow = rowCount++;

        uiLabelRow = rowCount++;
        uiAppNotificationIconRow = rowCount++;
        uiAppNotificationIconSelectorRow = rowCount++;
        uiStickerSizeLabelRow = rowCount++;
        uiStickerSizeRow = rowCount++;
        uiAppHidePhoneNumberOnLeftPanelRow = rowCount++;
        uiSystemFontRegularRow = -1;//TODO WTF need the fuck make it work
        uiSystemFontBoldRow = -1;
        uiSystemFontItalicRow = -1;
        uiSystemFontBoldItalicRow = -1;
        uiSystemFontMonoRow = -1;

        voiceLabelRow = -1;
        voiceHDRow = -1;
        voiceBadmanRow = -1;

        voipLabelRow = rowCount++;
        voipDisableStartBeep = rowCount++;
        voipDisableEndBeep = rowCount++;
        voipHDRow = -1;

        hardwareLabelRow = rowCount++;
        hardwareProximitySensorModeLabelRow = rowCount++;
        hardwareProximitySensorModeRow = rowCount++;
        hardwareDisableVibroRow = rowCount++;

        privacyLabelRow = rowCount++;
        privacyDontCallAppleRow = rowCount++;

        profileLabelRow = rowCount++;
        profileUIDRow = rowCount++;
        profileDCIDRow = rowCount++;
        profileSBRow = rowCount++;

        chatLabelRow = rowCount++;
        chatDeleteMarkRow = rowCount++;
        chatEnableMessageHistoryRow = rowCount++;
        chatSBFullRow = rowCount++;
        chatSBManagerRow = rowCount++;
        chatSwapToNextChannelRow = rowCount++;
        chatBottomOverlayNativeBehaviorRow = rowCount++;
        chatTabsOnForwardRow = rowCount++;
        chatDisableSpoilersRow = rowCount++;
        chatHideAllInSpoilersRow = rowCount++;
        chatRealForwardedMessageTimeRow = rowCount++;
        chatHideStickersRow = rowCount++;
        chatHideAnimatedStickersRow = rowCount++;
        chatHideVideoStickersRow = rowCount++;

        accountLabelRow = rowCount++;
        accountSessionManagerRow = rowCount++;
        accountExtendVanillaRow = -1;
        graheriumLabelRow = rowCount++;
        graheriumSpeedUpUpload = rowCount++;
        graheriumSpeedUpDownload = rowCount++;
        graheriumAnimateEveryAvatar = rowCount++;
        graheriumVanillaStickerFlow = rowCount++;
        graheriumAnimatedStickerOverlays = rowCount++;
        graheriumStarrLabelRow = rowCount++;
        graheriumStarrMark = rowCount++;
        graheriumOverrideConnectionSpeedLabelRow = rowCount++;
        graheriumOverrideConnectionSpeed = rowCount++;
        graheriumDisableEmojiStatus = rowCount++;
        graheriumDisablePremiumEmojis = rowCount++;

        gifLabelHDRow = rowCount++;
        gifHDRow = rowCount++;

        videoLabelMaxResolutionRow = rowCount++;
        videoMaxResolutionRow = rowCount++;
        videoLabelRoundBitrateRow = rowCount++;
        videoRoundBitrateMultRow = rowCount++;
        videoLabelRoundSizeRow = rowCount++;
        videoRoundSizeMultRow = rowCount++;
        videoRoundUseMainCameraRow = rowCount++;
        photoSizeMaxLabelRow = rowCount++;
        photoSizeMaxRow = rowCount++;

        deviceSpoofingLabelRow = rowCount++;
        deviceSpoofingBrand = rowCount++;
        deviceSpoofingModel = rowCount++;
        deviceSpoofingSDK = rowCount++;
        deviceSpoofingResetDefaultLabelRow = rowCount++;

        killMeLabelRow = rowCount++;

        NotificationCenter.getInstance(currentAccount).addObserver(this, NotificationCenter.telegraherSettingsUpdated);

        return super.onFragmentCreate();
    }

    @Override
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(currentAccount).removeObserver(this, NotificationCenter.telegraherSettingsUpdated);
    }

    @Override
    public View createView(Context context) {
        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setAllowOverlayTitle(true);
        actionBar.setTitle(LocaleController.getString(R.string.THSettingsLabel));
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() {
            @Override
            public void onItemClick(int id) {
                if (id == -1) {
                    finishFragment();
                }
            }
        });

        fragmentView = new FrameLayout(context);
        FrameLayout frameLayout = (FrameLayout) fragmentView;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));

        listView = new RecyclerListView(context);
        listView.setItemAnimator(null);
        listView.setLayoutAnimation(null);
        listView.setLayoutManager(layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        listView.setVerticalScrollBarEnabled(false);
        frameLayout.addView(listView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));
        listView.setAdapter(adapter = new TelegraherSettingsActivity.ListAdapter(context));
        listView.setOnItemClickListener((view, position, x, y) -> {
            boolean enabled = false;
            if (getParentActivity() == null) {
                return;
            }
            if (false) {
                //durov relogin!
            } else if (position == voiceHDRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableVoiceHD", false);
                editor.putBoolean("EnableVoiceHD", !enabled);
                if (enabled) editor.putBoolean("EnableVoiceBadman", false);
                editor.apply();
            } else if (position == voiceBadmanRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableVoiceBadman", false);
                editor.putBoolean("EnableVoiceBadman", preferences.getBoolean("EnableVoiceHD", false) && !enabled);
                if (!preferences.getBoolean("EnableVoiceHD", false)) enabled = true;
                editor.apply();
            } else if (position == voipHDRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableVoIPHD", false);
                editor.putBoolean("EnableVoIPHD", !enabled);
                editor.apply();
            } else if (position == voipDisableStartBeep) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("VoipDisableStartBeep", false);
                editor.putBoolean("VoipDisableStartBeep", !enabled);
                editor.apply();
            } else if (position == voipDisableEndBeep) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("VoipDisableEndBeep", false);
                editor.putBoolean("VoipDisableEndBeep", !enabled);
                editor.apply();
            } else if (position == privacyDontCallAppleRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("PrivacyDontCallApple", true);
                editor.putBoolean("PrivacyDontCallApple", !enabled);
                editor.apply();
            } else if (position == profileUIDRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableProfileUID", true);
                editor.putBoolean("EnableProfileUID", !enabled);
                editor.apply();
            } else if (position == profileDCIDRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableProfileDCID", true);
                editor.putBoolean("EnableProfileDCID", !enabled);
                editor.apply();
            } else if (position == profileSBRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableProfileSB", true);
                editor.putBoolean("EnableProfileSB", !enabled);
                editor.apply();
            } else if (position == chatDeleteMarkRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableChatDeleteMark", true);
                editor.putBoolean("EnableChatDeleteMark", !enabled);
                editor.apply();
            } else if (position == chatEnableMessageHistoryRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableMessageHistory", true);
                editor.putBoolean("EnableMessageHistory", !enabled);
                editor.apply();
            } else if (position == chatSBFullRow) {
                SharedPreferences preferences = MessagesController.getTelegraherSettings(currentAccount);
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableChatSBFull", false);
                editor.putBoolean("EnableChatSBFull", !enabled);
                editor.apply();
            } else if (position == chatSwapToNextChannelRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableSwapToNextChannel", false);
                editor.putBoolean("EnableSwapToNextChannel", !enabled);
                editor.apply();
            } else if (position == chatBottomOverlayNativeBehaviorRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("BottomOverlayNativeBehavior", false);
                editor.putBoolean("BottomOverlayNativeBehavior", !enabled);
                editor.apply();
            } else if (position == chatTabsOnForwardRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableTabsOnForward", false);
                editor.putBoolean("EnableTabsOnForward", !enabled);
                editor.apply();
            } else if (position == chatDisableSpoilersRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("DisableSpoilers", false);
                editor.putBoolean("DisableSpoilers", !enabled);
                editor.apply();
            } else if (position == chatHideAllInSpoilersRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("HideAllInSpoilers", false);
                editor.putBoolean("HideAllInSpoilers", !enabled);
                editor.apply();
            } else if (position == chatRealForwardedMessageTimeRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("RealForwardedMessageTime", true);
                editor.putBoolean("RealForwardedMessageTime", !enabled);
                editor.apply();
            } else if (position == chatHideStickersRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("HideStickers", false);
                editor.putBoolean("HideStickers", !enabled);
                editor.apply();
            } else if (position == chatHideAnimatedStickersRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("HideAnimatedStickers", false);
                editor.putBoolean("HideAnimatedStickers", !enabled);
                editor.apply();
            } else if (position == chatHideVideoStickersRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("HideVideoStickers", false);
                editor.putBoolean("HideVideoStickers", !enabled);
                editor.apply();
            } else if (position == accountExtendVanillaRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableAccountExtendVanilla", false);
                editor.putBoolean("EnableAccountExtendVanilla", !enabled);
                editor.apply();
            } else if (position == graheriumSpeedUpUpload) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableGraheriumSpeedUpUpload", false);
                editor.putBoolean("EnableGraheriumSpeedUpUpload", !enabled);
                editor.apply();
            } else if (position == graheriumSpeedUpDownload) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableGraheriumSpeedUpDownload", false);
                editor.putBoolean("EnableGraheriumSpeedUpDownload", !enabled);
                editor.apply();
            } else if (position == graheriumAnimateEveryAvatar) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableGraheriumAnimateEveryAvatar", false);
                editor.putBoolean("EnableGraheriumAnimateEveryAvatar", !enabled);
                editor.apply();
            } else if (position == graheriumAnimatedStickerOverlays) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableGraheriumAnimatedStickerOverlays", false);
                if (preferences.getBoolean("EnableGraheriumVanillaStickerFlow", true)) enabled = true;
                editor.putBoolean("EnableGraheriumAnimatedStickerOverlays", !preferences.getBoolean("EnableGraheriumVanillaStickerFlow", true) && !enabled);
                editor.apply();
            } else if (position == graheriumVanillaStickerFlow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableGraheriumVanillaStickerFlow", true);
                if (!enabled) editor.putBoolean("EnableGraheriumAnimatedStickerOverlays", false);
                editor.putBoolean("EnableGraheriumVanillaStickerFlow", !enabled);
                editor.apply();
            } else if (position == graheriumDisableEmojiStatus) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("GraheriumDisableEmojiStatus", false);
                editor.putBoolean("GraheriumDisableEmojiStatus", !enabled);
                editor.apply();
            } else if (position == graheriumDisablePremiumEmojis) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("GraheriumDisablePremiumEmojis", false);
                editor.putBoolean("GraheriumDisablePremiumEmojis", !enabled);
                editor.apply();
            } else if (position == gifHDRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("EnableGifHD", false);
                editor.putBoolean("EnableGifHD", !enabled);
                editor.apply();
            } else if (position == uiAppHidePhoneNumberOnLeftPanelRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("HidePhoneNumberOnLeftPanel", false);
                editor.putBoolean("HidePhoneNumberOnLeftPanel", !enabled);
                editor.apply();
            } else if (position == videoRoundUseMainCameraRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("VideoRoundUseMainCamera", false);
                editor.putBoolean("VideoRoundUseMainCamera", !enabled);
                editor.apply();
            } else if (position == hardwareDisableVibroRow) {
                SharedPreferences preferences = MessagesController.getGlobalTelegraherSettings();
                SharedPreferences.Editor editor = preferences.edit();
                enabled = preferences.getBoolean("HardwareDisableVibro", false);
                editor.putBoolean("HardwareDisableVibro", !enabled);
                editor.apply();
            } else if (position == killMeLabelRow) {
                killThatApp();
            } else if (position == chatSBManagerRow) {
                presentFragment(new ThShadowbanManagerActivity());
            } else if (position == accountSessionManagerRow) {
                presentFragment(new ThSessionManagerActivity());
//            } else if (position == uiSystemFontRegularRow) {
//                presentFragment(new UIFontActivity("fonts/rmedium.ttf", "regular"));
//            } else if (position == uiSystemFontBoldRow) {
//                presentFragment(new UIFontActivity("fonts/rmedium.ttf", "rmedium"));
//            } else if (position == uiSystemFontItalicRow) {
//                presentFragment(new UIFontActivity("fonts/ritalic.ttf", "ritalic"));
//            } else if (position == uiSystemFontBoldItalicRow) {
//                presentFragment(new UIFontActivity("fonts/rmediumitalic.ttf", "rmediumitalic"));
//            } else if (position == uiSystemFontMonoRow) {
//                presentFragment(new UIFontActivity("fonts/rmono.ttf", "rmono"));
            } else if (position == deviceSpoofingBrand) {
                presentFragment(new THDeviceSpoofingEditActivity(0, -1));
            } else if (position == deviceSpoofingModel) {
                presentFragment(new THDeviceSpoofingEditActivity(1, -1));
            } else if (position == deviceSpoofingSDK) {
                presentFragment(new THDeviceSpoofingEditActivity(2, -1));
            } else if (position == deviceSpoofingResetDefaultLabelRow) {
                showDSResetGlobalAlert();
            }
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(!enabled);
            }
        });

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void didReceivedNotification(int id, int account, Object... args) {
        if (false) {
            //durov relogin!
        } else if (id == NotificationCenter.telegraherSettingsUpdated) {
            adapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {

        private Context mContext;

        public ListAdapter(Context context) {
            mContext = context;
        }

        @Override
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int position = holder.getAdapterPosition();
            return !(
                position == voiceLabelRow || position == voipLabelRow);
        }

        @Override
        public int getItemCount() {
            return rowCount;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case 0:
                    view = new HeaderCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 1:
                    view = new TextCheckCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 2:
                    view = new TextDetailSettingsCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 3:
                    view = new NotificationsCheckCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 4:
                    view = new ShadowSectionCell(mContext);
                    break;
                case 5:
                    view = new TextSettingsCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 6:
                    view = new SlideChooseView(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 7:
                    view = new TextDetailCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                default:
                    view = new TextInfoPrivacyCell(mContext);
                    view.setBackgroundDrawable(Theme.getThemedDrawable(mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    break;
            }
            return new RecyclerListView.Holder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            switch (holder.getItemViewType()) {
                case 0: {
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (false) {
                        //durov relogin!
                    } else if (position == uiLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THUILabelRow));
                    } else if (position == uiAppNotificationIconRow) {
                        headerCell.setText(LocaleController.getString(R.string.THUIAppNotificationIconRow));
                    } else if (position == uiStickerSizeLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THUIStickerSize));
                    } else if (position == voiceLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THVoiceLabelRow));
                    } else if (position == voipLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THVoipLabelRow));
                    } else if (position == privacyLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THPrivacyRowLabel));
                    } else if (position == profileLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THProfileLabelRow));
                    } else if (position == hardwareLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THHardwareLabelRow));
                    } else if (position == hardwareProximitySensorModeLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THHardwareProximitySensorModeRow));
                    } else if (position == chatLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THChatLabelRow));
                    } else if (position == gifLabelHDRow) {
                        headerCell.setText(LocaleController.getString(R.string.THGifLabelHDRow));
                    } else if (position == videoLabelMaxResolutionRow) {
                        headerCell.setText(LocaleController.getString(R.string.THVideoLabelMaxResolutionRow));
                    } else if (position == videoLabelRoundBitrateRow) {
                        headerCell.setText(LocaleController.getString(R.string.THVideoLabelRoundBitrateRow));
                    } else if (position == videoLabelRoundSizeRow) {
                        headerCell.setText(LocaleController.getString(R.string.THVideoLabelRoundSizeRow));
                    } else if (position == accountLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THAccountLabelRow));
                    } else if (position == graheriumLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THDGraheriumLabelRow));
                    } else if (position == graheriumStarrLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THGraheriumStarrLabel));
                    } else if (position == graheriumOverrideConnectionSpeedLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THGraheriumOverrideConnectionSpeed));
                    } else if (position == deviceSpoofingLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THDeviceSpoofingLabelRow));
                    } else if (position == deviceSpoofingResetDefaultLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THDeviceSpoofingResetDefaultLabelRow));
                    } else if (position == showLabelTelegraherMenuRow) {
                        headerCell.setText(LocaleController.getString(R.string.THShowLabelTelegraherMenuRow));
                    } else if (position == photoSizeMaxLabelRow) {
                        headerCell.setText(LocaleController.getString(R.string.THPhotoMaxSize));
                    }
                    break;
                }
                case 1: {
                    TextCheckCell checkCell = (TextCheckCell) holder.itemView;
                    SharedPreferences localPreps = MessagesController.getTelegraherSettings(currentAccount);
                    SharedPreferences globalPreps = MessagesController.getGlobalTelegraherSettings();
                    if (false) {
                        //durov relogin!
                    } else if (position == voiceHDRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableVoiceHD), globalPreps.getBoolean("EnableVoiceHD", false), false);
                    } else if (position == voiceBadmanRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableVoiceBadman), globalPreps.getBoolean("EnableVoiceBadman", false), true);
                    } else if (position == voipHDRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableVoIPHD), localPreps.getBoolean("EnableVoIPHD", false), true);
                    } else if (position == voipDisableStartBeep) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THVoipDisableStartBeep), globalPreps.getBoolean("VoipDisableStartBeep", false), true);
                    } else if (position == voipDisableEndBeep) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THVoipDisableEndBeep), globalPreps.getBoolean("VoipDisableEndBeep", false), true);
                    } else if (position == privacyDontCallAppleRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THPrivacyDontCallApple), globalPreps.getBoolean("PrivacyDontCallApple", true), true);
                    } else if (position == profileUIDRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableProfileUID), localPreps.getBoolean("EnableProfileUID", true), true);
                    } else if (position == hardwareDisableVibroRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THHardwareDisableVibroRow), globalPreps.getBoolean("HardwareDisableVibro", false), true);
                    } else if (position == profileDCIDRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableProfileDCID), localPreps.getBoolean("EnableProfileDCID", true), true);
                    } else if (position == profileSBRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableProfileSB), localPreps.getBoolean("EnableProfileSB", true), true);
                    } else if (position == chatDeleteMarkRow) {
                        checkCell.setTextAndCheck(String.format(LocaleController.getString(R.string.THEnableChatDeleteMark), LocaleController.getString("DeletedMessage", R.string.DeletedMessage)), localPreps.getBoolean("EnableChatDeleteMark", true), true);
                    } else if (position == chatEnableMessageHistoryRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableMessageHistory), localPreps.getBoolean("EnableMessageHistory", true), true);
                    } else if (position == accountExtendVanillaRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableAccountExtendVanilla), globalPreps.getBoolean("EnableAccountExtendVanilla", false), true);
                    } else if (position == graheriumSpeedUpUpload) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THDGraheriumSpeedUpUpload), globalPreps.getBoolean("EnableGraheriumSpeedUpUpload", false), true);
                    } else if (position == graheriumSpeedUpDownload) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THDGraheriumSpeedUpDownload), globalPreps.getBoolean("EnableGraheriumSpeedUpDownload", false), true);
                    } else if (position == graheriumAnimateEveryAvatar) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THGraheriumAnimateEveryAvatar), globalPreps.getBoolean("EnableGraheriumAnimateEveryAvatar", false), true);
                    } else if (position == graheriumAnimatedStickerOverlays) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THGraheriumAnimatedStickerOverlays), globalPreps.getBoolean("EnableGraheriumAnimatedStickerOverlays", false), true);
                    } else if (position == graheriumVanillaStickerFlow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THGraheriumVanillaStickerFlow), globalPreps.getBoolean("EnableGraheriumVanillaStickerFlow", true), true);
                    } else if (position == graheriumDisableEmojiStatus) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THGraheriumDisableEmojiStatus), globalPreps.getBoolean("GraheriumDisableEmojiStatus", false), true);
                    } else if (position == graheriumDisablePremiumEmojis) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THGraheriumDisablePremiumEmojis), globalPreps.getBoolean("GraheriumDisablePremiumEmojis", false), true);
                    } else if (position == uiAppHidePhoneNumberOnLeftPanelRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THHidePhoneNumberOnLeftPanel), globalPreps.getBoolean("HidePhoneNumberOnLeftPanel", false), true);
                    } else if (position == chatSBFullRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableChatSBFull), localPreps.getBoolean("EnableChatSBFull", false), true);
                    } else if (position == chatSwapToNextChannelRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableSwapToNextChannel), globalPreps.getBoolean("EnableSwapToNextChannel", false), true);
                    } else if (position == chatBottomOverlayNativeBehaviorRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THBottomOverlayNativeBehavior), globalPreps.getBoolean("BottomOverlayNativeBehavior", false), true);
                    } else if (position == chatTabsOnForwardRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableTabsOnForward), globalPreps.getBoolean("EnableTabsOnForward", false), true);
                    } else if (position == chatDisableSpoilersRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THDisableSpoilers), globalPreps.getBoolean("DisableSpoilers", false), true);
                    } else if (position == chatHideAllInSpoilersRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THHideAllInSpoilers), globalPreps.getBoolean("HideAllInSpoilers", false), true);
                    } else if (position == chatRealForwardedMessageTimeRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THChatRealForwardedMessageTime), globalPreps.getBoolean("RealForwardedMessageTime", true), true);
                    } else if (position == chatHideStickersRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THChatHideStickers), globalPreps.getBoolean("HideStickers", false), true);
                    } else if (position == chatHideAnimatedStickersRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THChatHideAnimatedStickers), globalPreps.getBoolean("HideAnimatedStickers", false), true);
                    } else if (position == chatHideVideoStickersRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THChatHideVideoStickers), globalPreps.getBoolean("HideVideoStickers", false), true);
                    } else if (position == gifHDRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THEnableGifHD), globalPreps.getBoolean("EnableGifHD", false), true);
                    } else if (position == videoRoundUseMainCameraRow) {
                        checkCell.setTextAndCheck(LocaleController.getString(R.string.THVideoRoundUseMainCamera), globalPreps.getBoolean("VideoRoundUseMainCamera", false), true);
                    }
                    break;
                }
                case 5: {
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    if (false) {
                        //durov relogin!
                    } else if (position == killMeLabelRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteRedText));
                        textSettingsCell.setText(LocaleController.getString(R.string.THKillTheAPP), false);
                    } else if (position == chatSBManagerRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setText(LocaleController.getString(R.string.THChatSBManager), false);
                    } else if (position == accountSessionManagerRow) {
                        textSettingsCell.setCanDisable(false);
                        int activeAccountsNumber = SharedConfig.activeAccounts == null ? 0 : SharedConfig.activeAccounts.size();
                        int offlineAccountsNumber = SharedConfig.thAccounts == null ? 0 : (SharedConfig.thAccounts.size() - activeAccountsNumber - 1);
                        textSettingsCell.setText(String.format(LocaleController.getString(R.string.THAccountSessionManager)
                            , activeAccountsNumber
                            , offlineAccountsNumber
                        ), false);
                    } else if (position == uiSystemFontRegularRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setText(LocaleController.getString(R.string.THUIUseCustomFontRegular), false);
                    } else if (position == uiSystemFontBoldRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setText(LocaleController.getString(R.string.THUIUseCustomFontBold), false);
                    } else if (position == uiSystemFontItalicRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setText(LocaleController.getString(R.string.THUIUseCustomFontItalic), false);
                    } else if (position == uiSystemFontBoldItalicRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setText(LocaleController.getString(R.string.THUIUseCustomFontBoldItalic), false);
                    } else if (position == uiSystemFontMonoRow) {
                        textSettingsCell.setCanDisable(false);
                        textSettingsCell.setText(LocaleController.getString(R.string.THUIUseCustomFontMono), false);
                    }
                    break;
                }
                case 6: {
                    SlideChooseView slideChooseView = (SlideChooseView) holder.itemView;
                    if (false) {
                        //durov relogin!
                    } else if (position == videoRoundBitrateMultRow) {
                        String[] strings = new String[]{"x0.5", "x1", "x2", "x4"};
                        slideChooseView.setOptions(MessagesController.getTelegraherSettings(currentAccount).getInt("VideoRoundBitrateMult", 1), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences localTh = MessagesController.getTelegraherSettings(currentAccount);
                                SharedPreferences localMain = MessagesController.getMainSettings(currentAccount);
                                SharedPreferences.Editor editor = localTh.edit();
                                editor.putInt("VideoRoundBitrateMult", index);
                                editor.apply();
                                editor = localMain.edit();
                                editor.putInt("roundVideoBitrate", (int) (1000 * ThePenisMightierThanTheSword.getVideoRoundMult(index)));
                                editor.putInt("roundAudioBitrate", (int) (64 * ThePenisMightierThanTheSword.getVideoRoundMult(index)));
                                editor.apply();
                                MessagesController.getInstance(currentAccount).roundVideoBitrate = MessagesController.getMainSettings(currentAccount).getInt("roundVideoBitrate", 1000);
                                MessagesController.getInstance(currentAccount).roundAudioBitrate = MessagesController.getMainSettings(currentAccount).getInt("roundAudioBitrate", 64);
//                                System.out.printf("HEY %d %d %d%n", MessagesController.getMainSettings(currentAccount).getInt("roundVideoSize", 384)
//                                    , MessagesController.getMainSettings(currentAccount).getInt("roundVideoBitrate", 1000)
//                                    , MessagesController.getMainSettings(currentAccount).getInt("roundAudioBitrate", 64));
                            }
                        });
                    } else if (position == videoRoundSizeMultRow) {
                        String[] strings = new String[]{"x0.5", "x1", "x2"};
                        slideChooseView.setOptions(MessagesController.getTelegraherSettings(currentAccount).getInt("VideoRoundSizeMult", 1), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences localTh = MessagesController.getTelegraherSettings(currentAccount);
                                SharedPreferences localMain = MessagesController.getMainSettings(currentAccount);
                                SharedPreferences.Editor editor = localTh.edit();
                                editor.putInt("VideoRoundSizeMult", index);
                                editor.apply();
                                editor = localMain.edit();
                                editor.putInt("roundVideoSize", ThePenisMightierThanTheSword.getVideoRoundSize(index));
                                editor.apply();
                                MessagesController.getInstance(currentAccount).roundVideoSize = MessagesController.getMainSettings(currentAccount).getInt("roundVideoSize", 384);
//                                System.out.printf("HEY %d %d %d%n", MessagesController.getMainSettings(currentAccount).getInt("roundVideoSize", 384)
//                                    , MessagesController.getMainSettings(currentAccount).getInt("roundVideoBitrate", 1000)
//                                    , MessagesController.getMainSettings(currentAccount).getInt("roundAudioBitrate", 64));
                            }
                        });
                    } else if (position == photoSizeMaxRow) {
                        String[] strings = new String[]{"1280", "2560", "3840"};
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("photoSizeMaxIndex", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences localTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = localTh.edit();
                                editor.putInt("photoSizeMaxIndex", index);
                                editor.putInt("photoSizeMax", ThePenisMightierThanTheSword.getPhotoSizeMax(index));
                                editor.apply();
                            }
                        });
                    } else if (position == showTelegraherMenuRow) {
                        String[] strings = new String[]{LocaleController.getString(R.string.THMenuPositionBoth), LocaleController.getString(R.string.THMenuPositionSettings), LocaleController.getString(R.string.THMenuPositionStorageUsage), LocaleController.getString(R.string.THMenuPositionTheVoid)};
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("ShowTelegraherMenu2", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("ShowTelegraherMenu2", index);
                                editor.apply();
                            }
                        });
                    } else if (position == videoMaxResolutionRow) {
                        String[] strings = new String[]{"FullHD", "2k", "4k", "8k"};
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("VideoMaxResolution", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("VideoMaxResolution", index);
                                editor.apply();
                            }
                        });
                    } else if (position == hardwareProximitySensorModeRow) {
                        String[] strings = new String[]{
                            LocaleController.getString(R.string.THHardwareProximitySensorModeRow0),
                            LocaleController.getString(R.string.THHardwareProximitySensorModeRow1),
                            LocaleController.getString(R.string.THHardwareProximitySensorModeRow2)
                        };
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("HardwareProximitySensorMode", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("HardwareProximitySensorMode", index);
                                editor.apply();
                            }
                        });
                    } else if (position == uiAppNotificationIconSelectorRow) {
                        String[] strings = new String[]{
                            LocaleController.getString(R.string.THUIAppNotificationIconRow0),
                            LocaleController.getString(R.string.THUIAppNotificationIconRow1),
                            LocaleController.getString(R.string.THUIAppNotificationIconRow2),
                            LocaleController.getString(R.string.THUIAppNotificationIconRow3)
                        };
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("UIAppNotificationIconSelector", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("UIAppNotificationIconSelector", index);
                                editor.apply();
                            }
                        });
                    } else if (position == uiStickerSizeRow) {
                        String[] strings = new String[]{
                            "x0.25",
                            "x0.5",
                            "x1",
                            "x2",
                        };
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("UIStickerSize", 2), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("UIStickerSize", index);
                                editor.apply();
                            }
                        });
                    } else if (position == graheriumStarrMark) {
                        String[] strings = new String[]{LocaleController.getString(R.string.THGraheriumStarrNoone), LocaleController.getString(R.string.THGraheriumStarrEveryone), LocaleController.getString(R.string.THGraheriumStarrPeperemiumOnly)};
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("GraheriumStarrMark", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("GraheriumStarrMark", index);
                                editor.apply();
                            }
                        });
                    } else if (position == graheriumOverrideConnectionSpeed) {
                        String[] strings = new String[]{LocaleController.getString(R.string.THGraheriumOverrideConnectionSpeedAuto), LocaleController.getString(R.string.THGraheriumOverrideConnectionSpeedSlow), LocaleController.getString(R.string.THGraheriumOverrideConnectionSpeedHigh)};
                        slideChooseView.setOptions(MessagesController.getGlobalTelegraherSettings().getInt("GraheriumConnectionSpeed", 0), strings);
                        slideChooseView.setCallback(new SlideChooseView.Callback() {
                            @Override
                            public void onOptionSelected(int index) {
                                SharedPreferences globalTh = MessagesController.getGlobalTelegraherSettings();
                                SharedPreferences.Editor editor = globalTh.edit();
                                editor.putInt("GraheriumConnectionSpeed", index);
                                editor.apply();
                            }
                        });
                    }
                    break;
                }
                case 7: {
                    TextDetailCell textDetailCell = (TextDetailCell) holder.itemView;
                    if (false) {
                        //durov relogin!
                    } else if (position == deviceSpoofingBrand) {
                        textDetailCell.setContentDescriptionValueFirst(true);
                        textDetailCell.setTextAndValue(SharedConfig.thDeviceSpoofing.get(-1).get("deviceBrand"), String.format(LocaleController.getString(R.string.THDSBrandCurrentText), SharedConfig.thDeviceSpoofing.containsKey(currentAccount) ? SharedConfig.thDeviceSpoofing.get(currentAccount).get("deviceBrand") : "-"), false);
                    } else if (position == deviceSpoofingModel) {
                        textDetailCell.setContentDescriptionValueFirst(true);
                        textDetailCell.setImageClickListener(TelegraherSettingsActivity.this::onTextDetailCellImageClicked);
                        textDetailCell.setTextAndValue(SharedConfig.thDeviceSpoofing.get(-1).get("deviceModel"), String.format(LocaleController.getString(R.string.THDSModelCurrentText), SharedConfig.thDeviceSpoofing.containsKey(currentAccount) ? SharedConfig.thDeviceSpoofing.get(currentAccount).get("deviceModel") : "-"), false);
                    } else if (position == deviceSpoofingSDK) {
                        textDetailCell.setContentDescriptionValueFirst(true);
                        textDetailCell.setImageClickListener(TelegraherSettingsActivity.this::onTextDetailCellImageClicked);
                        textDetailCell.setTextAndValue(SharedConfig.thDeviceSpoofing.get(-1).get("deviceSDK"), String.format(LocaleController.getString(R.string.THDSSDKCurrentText), SharedConfig.thDeviceSpoofing.containsKey(currentAccount) ? SharedConfig.thDeviceSpoofing.get(currentAccount).get("deviceSDK") : "-"), false);
                    }
                    break;
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (
                position == showLabelTelegraherMenuRow
                    || position == uiLabelRow
                    || position == uiAppNotificationIconRow
                    || position == uiStickerSizeLabelRow
                    || position == voiceLabelRow || position == voipLabelRow
                    || position == privacyLabelRow
                    || position == profileLabelRow
                    || position == hardwareLabelRow
                    || position == hardwareProximitySensorModeLabelRow
                    || position == chatLabelRow
                    || position == gifLabelHDRow
                    || position == accountLabelRow
                    || position == graheriumLabelRow
                    || position == graheriumStarrLabelRow
                    || position == graheriumOverrideConnectionSpeedLabelRow
                    || position == deviceSpoofingLabelRow
                    || position == deviceSpoofingResetDefaultLabelRow
                    || position == videoLabelMaxResolutionRow
                    || position == videoLabelRoundBitrateRow
                    || position == videoLabelRoundSizeRow
                    || position == photoSizeMaxLabelRow
            ) {
                return 0;
            } else if (
                position == voiceHDRow || position == voiceBadmanRow
                    || position == voipHDRow || position == voipDisableStartBeep || position == voipDisableEndBeep
                    || position == privacyDontCallAppleRow
                    || position == profileUIDRow || position == profileDCIDRow || position == profileSBRow
                    || position == hardwareDisableVibroRow
                    || position == chatDeleteMarkRow || position == chatEnableMessageHistoryRow || position == accountExtendVanillaRow || position == chatSBFullRow
                    || position == chatSwapToNextChannelRow || position == chatBottomOverlayNativeBehaviorRow || position == chatTabsOnForwardRow || position == chatDisableSpoilersRow || position == chatHideAllInSpoilersRow || position == chatRealForwardedMessageTimeRow
                    || position == chatHideStickersRow || position == chatHideAnimatedStickersRow || position == chatHideVideoStickersRow
                    || position == graheriumSpeedUpUpload || position == graheriumSpeedUpDownload || position == graheriumAnimateEveryAvatar || position == graheriumAnimatedStickerOverlays || position == graheriumVanillaStickerFlow || position == graheriumDisableEmojiStatus || position == graheriumDisablePremiumEmojis
                    || position == gifHDRow || position == videoRoundUseMainCameraRow
                    || position == uiAppHidePhoneNumberOnLeftPanelRow
            ) {
                return 1;
            } else if (position == killMeLabelRow || position == chatSBManagerRow || position == accountSessionManagerRow
                || position == uiSystemFontRegularRow || position == uiSystemFontBoldRow || position == uiSystemFontItalicRow || position == uiSystemFontBoldItalicRow || position == uiSystemFontMonoRow
            ) {
                return 5;
            } else if (
                position == showTelegraherMenuRow
                    || position == videoRoundBitrateMultRow || position == videoRoundSizeMultRow
                    || position == photoSizeMaxRow
                    || position == videoMaxResolutionRow
                    || position == hardwareProximitySensorModeRow
                    || position == uiAppNotificationIconSelectorRow
                    || position == uiStickerSizeRow
                    || position == graheriumStarrMark
                    || position == graheriumOverrideConnectionSpeed
            ) {
                return 6;
            } else if (position == deviceSpoofingBrand || position == deviceSpoofingModel || position == deviceSpoofingSDK) {
                return 7;
            } else
                return 1337;
        }
    }

    private void onTextDetailCellImageClicked(View view) {
        View parent = (View) view.getParent();
        if (parent.getTag() != null && ((int) parent.getTag()) == 1337) {
            Bundle args = new Bundle();
            presentFragment(new QrActivity(args));
        }
    }

    private void killThatApp() {
        if (Build.VERSION.SDK_INT >= 21) {
            getParentActivity().finishAndRemoveTask();
        } else if (Build.VERSION.SDK_INT >= 19) {
            getParentActivity().finishAffinity();
        }
        System.exit(0);
    }

//    private void showDSAlert(int labelId) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
//        builder.setTitle(LocaleController.getString(R.string.THDSLabel));
//        builder.setMessage(String.format(LocaleController.getString(R.string.THDSOverrideLabel), DSMainActivity.DS_LABEL[labelId]));
//        builder.setNeutralButton(LocaleController.getString(R.string.THDSOverrideGlobal), (dialogInterface, i) -> {
//            try {
//                presentFragment(new DSMainActivity(labelId, 0, labelId));
//            } catch (Exception durovrelogin) {
//                durovrelogin.printStackTrace();
//            }
//        });
//        builder.setPositiveButton(LocaleController.getString(R.string.THDSOverrideCurrent), (dialogInterface, i) -> {
//            try {
//                presentFragment(new DSMainActivity(labelId, 1, labelId));
//            } catch (Exception durovrelogin) {
//                durovrelogin.printStackTrace();
//            }
//        });
//        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
//        AlertDialog dialog = builder.create();
//        showDialog(dialog);
//        TextView button = (TextView) dialog.getButton(DialogInterface.BUTTON_POSITIVE);
//        if (button != null) {
//            button.setTextColor(Theme.getColor(Theme.key_dialogTextRed2));
//        }
//        button = (TextView) dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
//        if (button != null) {
//            button.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
//        }
//    }

//    private ArrayList<String> loadSystemFonts() {
//        ArrayList<String> fonts = new ArrayList<>();
//        fonts.add("fonts/rmedium.ttf");
//        try {
//            File dir = new File("/system/fonts");
//            String[] files = dir.list();
//            if (files == null) return fonts;
//            fonts.addAll(Arrays.asList(files));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fonts;
//    }

    private void showDSResetGlobalAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString(R.string.THDSLabel));
        builder.setMessage(LocaleController.getString(R.string.THDSResetAlert));
        builder.setPositiveButton(LocaleController.getString(R.string.THYesYesYes), (dialogInterface, i) -> {
            try {
                SharedConfig.thDeviceSpoofing.put(-1,
                    new HashMap<String, String>() {{
                        put("deviceBrand", Build.MANUFACTURER);
                        put("deviceModel", Build.MODEL);
                        put("deviceSDK", Integer.valueOf(Build.VERSION.SDK_INT).toString());
                    }});
            } catch (Exception durovrelogin) {
                durovrelogin.printStackTrace();
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog dialog = builder.create();
        showDialog(dialog);
        TextView button = (TextView) dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        if (button != null) {
            button.setTextColor(Theme.getColor(Theme.key_dialogTextRed2));
        }
    }

    @Override
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> themeDescriptions = new ArrayList<>();

        themeDescriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCheckCell.class, TextDetailSettingsCell.class, TextSettingsCell.class, NotificationsCheckCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        themeDescriptions.add(new ThemeDescription(fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));

        themeDescriptions.add(new ThemeDescription(actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        themeDescriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_actionBarDefault));
        themeDescriptions.add(new ThemeDescription(actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        themeDescriptions.add(new ThemeDescription(actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        themeDescriptions.add(new ThemeDescription(actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));

        themeDescriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteBlueHeader));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, null, null, null, Theme.key_windowBackgroundWhiteGrayText2));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, null, null, null, Theme.key_switchTrack));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, null, null, null, Theme.key_switchTrackChecked));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, null, null, null, Theme.key_windowBackgroundWhiteGrayText2));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, null, null, null, Theme.key_switchTrack));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, null, null, null, Theme.key_switchTrackChecked));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, null, null, null, Theme.key_windowBackgroundWhiteGrayText2));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, null, null, null, Theme.key_windowBackgroundWhiteValueText));

        themeDescriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));

        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, null, null, null, Theme.key_windowBackgroundWhiteGrayText2));

        themeDescriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        themeDescriptions.add(new ThemeDescription(listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteGrayText4));
        themeDescriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, null, null, null, Theme.key_windowBackgroundWhiteLinkText));

        return themeDescriptions;
    }
}
